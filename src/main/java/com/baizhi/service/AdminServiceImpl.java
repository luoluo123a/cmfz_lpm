package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin queryOne(String name, String pwd) {
        Admin admin = adminMapper.queryByName(name);
        if (admin == null) return null;
        if (!admin.getPwd().equals(pwd)) return null;
        return admin;
    }

    @Override
    public void insertAdmin(Admin admin) {

    }

    @Override
    public void quit(HttpSession session) {
        session.invalidate();
    }
}
