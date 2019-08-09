/**
 * Copyright (C), 2019
 * 文件名: selfInfoController
 * 作者:   HU
 * 日期:     2019/8/8 8:48
 * 描述:
 */
package com.app.controller;

import com.app.controller.validation.ValidGroup1;
import com.app.entity.AppInfoExample;
import com.app.entity.DevUser;
import com.app.service.BackendUserService;
import com.app.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@RequestMapping("/admin")
@Controller
public class backendController {
   @Autowired
    BackendUserService backendUserService;
    @RequestMapping("/index")
    public String queryNotPassAppInfoList(Model model) throws Exception{
        List<AppInfoExample> appInfoExampleList = backendUserService.findCheckNotPassAppInfoList();
        model.addAttribute("appInfoExampleList",appInfoExampleList);
        return  "admin/index" ;
    }
    @RequestMapping("/passList")
    public String queryPassAppInfoList(Model model) throws Exception{
        List<AppInfoExample> appInfoExampleList = backendUserService.findCheckPassAppInfoList();
        model.addAttribute("appInfoExampleList",appInfoExampleList);
        return  "admin/index" ;
    }
    @RequestMapping("/checkNotPass/{id}")
    public String checkNotPass(@PathVariable  Long id) throws Exception{
        backendUserService.checkNotPass(id);
        return  "admin/index" ;
    }
    @RequestMapping("/checkPass/{id}")
    public String checkPass(@PathVariable  Long id) throws Exception{
       backendUserService.checkPass(id);
        return  "admin/index" ;
    }
}