package com.baizhi.mapper;

import com.baizhi.entity.Guru;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GuruMapper extends Mapper<Guru> {
    public List<Guru> queryAll();
}
