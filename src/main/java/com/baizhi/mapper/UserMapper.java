package com.baizhi.mapper;

import com.baizhi.dto.UserDto;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMapper extends Mapper<User> {
    public Integer queryCountM(Integer day);//

    public List<UserDto> queryProvince();//地区

}
