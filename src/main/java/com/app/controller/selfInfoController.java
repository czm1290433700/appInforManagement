/**
 * Copyright (C), 2019
 * 文件名: selfInfoController
 * 作者:   HU
 * 日期:     2019/8/8 8:48
 * 描述:
 */
package com.app.controller;

import com.app.controller.validation.ValidGroup1;
import com.app.entity.DevUser;
import com.app.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class selfInfoController {
    @Autowired
    DevUserService devUserService;
    @RequestMapping("/selfInfoQuery")
    public String query(HttpSession session) throws Exception{
        DevUser devUser =(DevUser) session.getAttribute("devUser");
        return  "dev/selfInfo" ;
    }
    @RequestMapping("/editDevInfoSubmit")
    public String editItemsSubmit(Model model, HttpServletRequest request,
                                  @Validated(value = {ValidGroup1.class}) DevUser devUser, BindingResult bindingResult) throws Exception{

        if(bindingResult.hasErrors())
        {
            List<ObjectError> editUserInfoErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : editUserInfoErrors) {
                System.out.println(objectError.getDefaultMessage());

            }
            model.addAttribute("editUserInfoErrors",editUserInfoErrors);
            return "dev/selfInfo";
        }

        if(devUserService.modifyDevUser(devUser)){
            model.addAttribute("editUserInfoSuccess","完成");
        }
        //  	return "forward:queryItems.action";
        //重定向
//    	return "redirect:queryItems.action";
        return "dev/selfInfo";
    }


}