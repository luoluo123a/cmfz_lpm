package com.baizhi.service;

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
}
