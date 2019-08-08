package com.app.controller;

import com.app.common.CodeCaptchaServlet;
import com.app.entity.DevUser;
import com.app.service.DevUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController extends BaseController{
    private final static Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    DevUserService devUserService;

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

}
