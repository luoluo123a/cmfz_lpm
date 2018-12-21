package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    //查询总行数
    public Integer TotalCount();

    //查当前页的行
    public List<Banner> queryByPage(@Param("curPage") int curPage, @Param("pageSize") int pageSize);
}
