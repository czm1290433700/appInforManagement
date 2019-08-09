package com.app.controller;

import com.app.common.CodeCaptchaServlet;
import com.app.common.MD5Util;
import com.app.entity.DevUser;
import com.app.mail.SendEmail;
import com.app.service.DevUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class RegisterController extends BaseController{
    private final static Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    DevUserService devUserService;
    @Autowired// redis数据库操作模板
    private RedisTemplate<String, String> redisTemplate;// jdbcTemplate HibernateTemplate

    /**
     * 判断验证码是否正确
     *
     * @param code
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code) {
        log.debug("注册-判断验证码" + code + "是否可用");
        String vcode = (String) getRequest().getSession().getAttribute(CodeCaptchaServlet.VERCODE_KEY);

        if (code.equals(vcode)) {
            //验证码正确
            return "success";
        } else {
            //验证码错误
            return "false";
        }
    }

    /**
     * 判断手机号是否已经被注册
     *
     * @param telephone
     * @return
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public String checkPhone(String telephone) {
        log.debug("注册-判断手机号" + telephone + "是否可用");
        DevUser devUser = devUserService.userSelectByPhone(telephone);
        if (devUser == null) {
            //未注册
            return "success";
        } else {
            //已注册
            return "fail";
        }
    }

    /**
     * 判断邮箱是否已经被注册
     *
     * @param email
     * @return
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(String email) {
        log.debug("注册-判断邮箱" + email + "是否可用");
        DevUser user = devUserService.userSelectByEmail(email);
        if (user == null) {
            //未注册
            return "success";
        } else {
            //已注册
            return "fail";
        }
    }

    /**
     * 匹对验证码的正确性
     * @param code
     * @return
     */
    public int checkValidateCode(String code) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object vercode = attrs.getRequest().getSession().getAttribute("VERCODE_KEY");
        if (null == vercode) {
            return -1;
        }
        if (!code.equalsIgnoreCase(vercode.toString())) {
            return 0;
        }
        return 1;
    }

    /**
     * 用户注册
     * @param model
     * @param username
     * @param email
     * @param password
     * @param telephone
     * @param code
     * @return
     */
    @RequestMapping(value = "/doRegister",produces="text/html;charset=UTF-8;")
    public String doRegister(Model model, String username, String email, String password, String telephone, String code) {
        log.debug("注册...");
        if (StringUtils.isBlank(code)) {
            model.addAttribute("error", "非法注册，请重新注册！");
            return "../register";
        }
        int b = checkValidateCode(code);
        if (b == -1) {
            model.addAttribute("error", "验证码超时，请重新注册！");
            return "../register";
        } else if (b == 0) {
            model.addAttribute("error", "验证码不正确,请重新输入!");
            return "../register";
        }
        DevUser devUser = devUserService.userSelectByEmail(email);
        if (devUser != null) {
            model.addAttribute("error", "该用户已经被注册！");
            return "../register";
        } else {
            Date date = new Date();
            devUser = new DevUser();
            devUser.setDevEmail(email);
            devUser.setPhone(telephone);
            devUser.setCreationDate(date);
            devUser.setDevInfo("");
            devUser.setDevName(username);
            devUser.setDevPassword(MD5Util.encodeToHex("salt"+password));
            devUser.setEnable("0");
            devUser.setState("0");
            //邮件激活码
            String validateCode = MD5Util.encodeToHex("salt"+email + password);
            redisTemplate.opsForValue().set(email, validateCode, 24, TimeUnit.HOURS);// 24小时 有效激活 redis保存激活码
            devUserService.register(devUser);
            log.info("注册成功");
            SendEmail.sendEmailMessage(email, validateCode);
            String message = email + "," + validateCode;
            model.addAttribute("message", message);
            return "/regist/registerSuccess";

        }
    }

    /**
     * 页面激活
     * @param model
     * @return
     */
    @RequestMapping("/activecode")
    public String active(Model model) {
        log.info( "==============激活验证==================" );
        //判断   激活有无过期 是否正确
        //validateCode=
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String validateCode = attrs.getRequest().getParameter( "validateCode" );
        String email = attrs.getRequest().getParameter( "email" );
        String code = redisTemplate.opsForValue().get( email );
        log.info( "验证邮箱为："+email+",邮箱激活码为："+code+",用户链接的激活码为："+validateCode );
        //判断是否已激活

        DevUser userTrue =devUserService.userSelectByEmail(email);
        if(userTrue!=null && "1".equals( userTrue.getState() )){
            //已激活
            model.addAttribute( "success","您已激活,请直接登录！" );
            return "../login";
        }

        if(code==null){
            //激活码过期
            model.addAttribute( "fail","您的激活码已过期,请重新注册！" );
            devUserService.deleteByEmail(email);
            return "/regist/activeFail";
        }

        if(StringUtils.isNotBlank( validateCode ) && validateCode.equals( code )){
            //激活码正确
            userTrue.setEnable( "1" );
            userTrue.setState( "1" );
            devUserService.update( userTrue );
            model.addAttribute( "email",email );
            return "/regist/activeSuccess";
        }else {
            //激活码错误
            model.addAttribute( "fail","您的激活码错误,请重新激活！" );
            return "/regist/activeFail";
        }

    }

}
