package com.app.controller;

import com.app.common.Constants;
import com.app.common.MD5Util;
import com.app.common.RandStringUtils;
import com.app.entity.DevUser;
import com.app.mail.SendEmail;
import com.app.service.DevUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Create by CZM on 2019/8/7
 */
@Controller
public class LoginController extends BaseController{
    private final static Logger log = Logger.getLogger( LoginController.class);
    private ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    @Autowired
    DevUserService devUserService;

    @Autowired// redis数据库操作模板
    private RedisTemplate<String, String> redisTemplate;// jdbcTemplate HibernateTemplate

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;// mq消息模板.

    /**
     * 账号密码登录
     * @param id
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/passwordLogin",method = RequestMethod.POST)
    @ResponseBody
    public String passwordLogin(Integer id, String password, HttpSession httpSession) {
        log.debug("登录验证" + id + "和" + password + "是否可用");
        DevUser devUser = devUserService.userSelectById(id);
        if (devUser == null) {
            return "false";
        } else {
            password = MD5Util.encodeToHex(Constants.SALT + password);
            if (devUser.getDevPassword().equals(password)) {
                httpSession.setAttribute("devUser", devUser);
                return "success";
            } else {
                return "false";
            }
        }
    }

    /**
     * 手机验证登录
     * @param model
     * @param telephone
     * @param telephoneCode
     * @return
     */
    @RequestMapping(value = "/phoneLogin",method = RequestMethod.POST)
    public String phoneLogin(Model model, String telephone, String telephoneCode){
        //手机登录
        String yzm = redisTemplate.opsForValue().get( telephone );//从redis获取验证码
        if(telephoneCode.equals(yzm)){
            //验证码正确
            DevUser devUser = devUserService.userSelectByPhone(telephone);
            getSession().setAttribute("devUser", devUser);
            model.addAttribute("devUser", devUser);
            log.info("手机快捷登录成功");
            return "/index";
        }else {
            //验证码错误或过期
            model.addAttribute("error","phone_fail");
            return  "/login";
        }
    }

    /**
     * 发送手机验证码
     * @param telephone
     * @return
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public Map<String,Object> index(final String telephone ) {
        Map map = new HashMap<String,Object>(  );
        try { //  发送验证码操作
            final String code = RandStringUtils.getCode();
            redisTemplate.opsForValue().set(telephone, code, 60, TimeUnit.SECONDS);// 60秒 有效 redis保存验证码
            log.debug("--------短信验证码为："+code);
            // 调用ActiveMQ jmsTemplate，发送一条消息给MQ
            jmsTemplate.send("login_msg", new MessageCreator() {
                public Message createMessage(javax.jms.Session session) throws JMSException {
                    MapMessage mapMessage = session.createMapMessage();
                    mapMessage.setString("telephone",telephone);
                    mapMessage.setString("code", code);
                    return mapMessage;
                }
            });
        } catch (Exception e) {
            map.put( "msg",false );
        }
        map.put( "msg",true );
        return map;
    }

    /**
     * 发送邮件
     * @return
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public  Map<String,Object> sendEmail() {
        Map map = new HashMap<String,Object>(  );
        String validateCode = getRequest().getParameter( "validateCode" );
        String email = getRequest().getParameter( "email" );
        SendEmail.sendEmailMessage(email,validateCode);
        map.put( "success","success" );
        return map;
    }
}
