package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dto.AlbumPage;
import com.baizhi.entity.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
//import sun.net.www.http.HttpClient;
//import sun.net.www.http.HttpClient;


import java.io.IOException;
import java.util.List;

public interface AlbumService {
    public List<Album> queryAll();

    public Album queryById(Integer id);

    public void insertAlbum(Album album);

    public AlbumPage queryByPage(int curPage, int pageSize);


}
