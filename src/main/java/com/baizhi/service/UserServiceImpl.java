package com.baizhi.service;

import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Integer> queryCountM() {
        List<Integer> list = new ArrayList<>();
        list.add(userMapper.queryCountM(90));
        list.add(userMapper.queryCountM(7));
        list.add(userMapper.queryCountM(14));
        list.add(userMapper.queryCountM(21));
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserDto> queryProvince() {
        List<UserDto> userDtos = userMapper.queryProvince();
        return userDtos;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public void regist(User user) {
        userMapper.insert(user);
    }
}
