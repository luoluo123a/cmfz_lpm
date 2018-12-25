package com.baizhi.controller;

import com.baizhi.dto.AlbumPage;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("queryAll")
    public List<Album> queryAll() {
        List<Album> albums = albumService.queryAll();
        for (Album album : albums) {
            System.out.println(album);
        }
        return albums;
    }

    @RequestMapping("queryById")
    public Album queryById(Integer id) {
        Album album = albumService.queryById(id);
        return album;
    }

    @RequestMapping("insertAlbum")
    public void insertAlbum(Album album, MultipartFile fi2, HttpSession session) throws IllegalStateException, IOException {
        ServletContext ctx = session.getServletContext();
        // 上传路径
        String realPath = ctx.getRealPath("\\file");
        // 目标文件
        String src = fi2.getOriginalFilename();
        File descFile = new File(realPath + "/" + src);
        album.setCoverimg("\\file\\" + src);
        // 上传
        fi2.transferTo(descFile);
        albumService.insertAlbum(album);
    }

    @RequestMapping("queryByPage")
    public AlbumPage queryByPage(int page, int rows) {
        AlbumPage dto = albumService.queryByPage(page, rows);
        System.out.println(dto.getRows());
        return dto;

    }
}
