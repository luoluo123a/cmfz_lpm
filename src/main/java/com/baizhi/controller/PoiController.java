package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("poi")
public class PoiController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("testExport")
    public void testExport(HttpSession session, HttpServletResponse response) {
        ServletContext ctx = session.getServletContext();
        // 上传路径
        String realPath = ctx.getRealPath("");
        List<Album> albums = albumService.queryAll();
        for (Album album : albums) {
            album.setCoverimg(realPath + album.getCoverimg());
            System.out.println(album.getCoverimg());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑", "专辑"), Album.class, albums);
        try {
            String filename = URLEncoder.encode("album.xls", "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
