package com.baizhi.service;

import com.baizhi.dto.PageDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> queryAll() {
        List<Banner> banners = bannerMapper.selectAll();
        return banners;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner queryById(Integer id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return banner;
    }

    @Override
    public void insertBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void deleteBanner(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageDto queryByPage(int curPage, int pageSize) {
        PageDto dto = new PageDto();
        //设置总行数
        dto.setTotal(bannerMapper.TotalCount());
        //设置当前页的数据行
        dto.setRows(bannerMapper.queryByPage(curPage, pageSize));
        return dto;
    }
}
