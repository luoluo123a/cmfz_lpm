package com.baizhi.service;

import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public List<Integer> queryCountM();

    public List<UserDto> queryProvince();

    public List<User> queryAll();

    public void regist(User user);
}
