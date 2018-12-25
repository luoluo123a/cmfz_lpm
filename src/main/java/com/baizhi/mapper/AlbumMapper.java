package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    public List<Album> queryAll();

    //查询总行数
    public Integer TotalCount();

    //查当前页的行
    public List<Album> queryByPage(@Param("curPage") int curPage, @Param("pageSize") int pageSize);

}
