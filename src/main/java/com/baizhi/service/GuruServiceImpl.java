package com.baizhi.service;

import com.baizhi.entity.Guru;
import com.baizhi.mapper.GuruMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruMapper guruMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> queryAll() {
        List<Guru> gurus = guruMapper.queryAll();
        return gurus;
    }
}
