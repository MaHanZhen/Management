package com.gdaib.controller;

import com.gdaib.pojo.AccountInfo;
import com.gdaib.service.UsersService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Author:马汉真
 * @Date: 17-5-9
 * @role:
 */
@Controller
public class ContentController {
    @Autowired
    private UsersService usersService;

    public static final String DEPARTMENTPAGE = "/teacher/departmentpage.jsp";
    public static final String PERSONALPAGE="/teacher/personalpage.jsp";




    //获取页面内容的接口
    @RequestMapping("/content/departmentpage")
    public ModelAndView departmentpage() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(DEPARTMENTPAGE);
        return  modelAndView;
    }


    //获取个人信息的接口

    @RequestMapping("/content/personalpage")
    @RequiresPermissions("content:query")//执行personalpage需要content:query权限
    public ModelAndView personalpage() throws Exception{
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName(PERSONALPAGE);
        return modelAndView;
    }



}
