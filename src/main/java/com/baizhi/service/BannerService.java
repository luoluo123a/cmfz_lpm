package com.baizhi.service;

import com.baizhi.dto.PageDto;
import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAll();

    public Banner queryById(Integer id);

    public void insertBanner(Banner banner);

    public void deleteBanner(Integer id);

    public void updateBanner(Banner banner);

    public PageDto queryByPage(int curPage, int pageSize);
}
