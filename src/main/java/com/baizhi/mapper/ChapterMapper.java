package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChapterMapper extends Mapper<Chapter> {
    public List<Chapter> queryAllChapterByAlbumId(Integer albumId);
}
