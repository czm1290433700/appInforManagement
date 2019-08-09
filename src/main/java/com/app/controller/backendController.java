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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class backendController {
//    @Autowired
   // BackendService devUserService;
    @RequestMapping("/admin")
    public String query(HttpSession session) throws Exception{
        return  "admin/index" ;
    }
}