package com.baizhi.service;

import com.baizhi.dto.AlbumPage;
import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> queryAll();

    public Album queryById(Integer id);

    public void insertAlbum(Album album);

    public AlbumPage queryByPage(int curPage, int pageSize);
}
