package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryCountM")
    public List<Integer> queryCountM() {
        List<Integer> list = userService.queryCountM();
        return list;
    }

    @RequestMapping("queryProvince")
    public List<UserDto> queryProvince() {
        List<UserDto> userDtos = userService.queryProvince();
//        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-a36c38bc99ab4be39f74d7840201943e");
//        goEasy.publish("140","Hello, GoEasy!");
        return userDtos;
    }

    @RequestMapping("queryAll")
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        return users;
    }

    @RequestMapping("insertUser")
    public void registUser() {
        List<Integer> list = userService.queryCountM();
        String s = JSONObject.toJSONString(list);
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-a36c38bc99ab4be39f74d7840201943e");
        goEasy.publish("140", s);
    }
}
