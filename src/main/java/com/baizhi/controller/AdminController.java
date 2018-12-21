package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(String name, String pwd, HttpSession session) {
        Admin admin = adminService.queryOne(name, pwd);
        if (admin == null) {
            return "redirect:/login.jsp";
        } else {
            session.setAttribute("admin", admin);
            return "main/main";
        }
    }

    @RequestMapping("quit")
    public String quit(HttpSession session) {//退出
        adminService.quit(session);
        return "success";
    }

}
