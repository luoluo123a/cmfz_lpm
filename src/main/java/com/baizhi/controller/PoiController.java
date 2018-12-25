package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Album;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumService;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("poi")
public class PoiController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private UserService userService;
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

    @RequestMapping("userExport")
    public void userExport(HttpSession session, HttpServletResponse response) {
        ServletContext ctx = session.getServletContext();
        // 上传路径
        String realPath = ctx.getRealPath("");
        List<User> users = userService.queryAll();
        for (User user : users) {
            user.setHeadpic(realPath + user.getHeadpic());
            System.out.println(user.getHeadpic());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户", "用户"), User.class, users);
        try {
            String filename = URLEncoder.encode("user.xls", "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("userImport")
    public void userImport() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);   //表格标题行数
        params.setHeadRows(1);   //表头行数
        List<User> list = ExcelImportUtil.importExcel(new File("C:\\Users\\Administrator\\Downloads\\user.xls"), User.class, params);
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(list.size());
    }
}
