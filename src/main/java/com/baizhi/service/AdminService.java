package com.baizhi.service;

import com.baizhi.entity.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public Admin queryOne(String name, String pwd);

    public void insertAdmin(Admin admin);

    public void quit(HttpSession session);
}
