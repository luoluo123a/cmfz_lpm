package com.baizhi.service;

import com.baizhi.dto.ChapterDto;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChapterDtoServiceImpl implements ChapterDtoService {
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public Object queryTwo(Integer id, Integer uid) {
        if (uid == null) {
            return "未登录";
        } else if (id == null) {
            return "参数错误";
        } else {
            Album album = albumMapper.selectByPrimaryKey(id);
            if (album == null) {
                return "该专辑不存在";
            } else {
                List<Chapter> chapters = chapterMapper.queryAllChapterByAlbumId(id);
                return new ChapterDto(chapters, album);
            }
        }

    }
}
