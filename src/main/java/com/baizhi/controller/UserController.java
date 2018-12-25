package com.baizhi.controller;

import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
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
    public List<Integer> queryCountM(Integer day) {
        List<Integer> list = userService.queryCountM(day);
        return list;
    }

    @RequestMapping("queryProvince")
    public List<UserDto> queryProvince() {
        List<UserDto> userDtos = userService.queryProvince();
        return userDtos;
    }

    @RequestMapping("queryAll")
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        return users;
    }
}
