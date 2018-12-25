package com.baizhi.service;

import com.baizhi.dto.AlbumPage;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> queryAll() {
        //PageHelper.startPage(1,2);
        List<Album> albums = albumMapper.queryAll();
        return albums;
    }

    public Album queryById(Integer id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    @Override
    public void insertAlbum(Album album) {
        albumMapper.insert(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public AlbumPage queryByPage(int curPage, int pageSize) {
        AlbumPage dto = new AlbumPage();
        //设置总行数
        dto.setTotal(albumMapper.TotalCount());
        //设置当前页的数据行
        dto.setRows(albumMapper.queryByPage(curPage, pageSize));
        return dto;
    }
}
