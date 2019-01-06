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
//        try {
//            Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\Administrator\\Downloads\\user.xls")));
//            Sheet sheet = workbook.getSheet("user");
//            int lastRowNum = sheet.getLastRowNum();
//            for (int i = 1; i < lastRowNum + 1; i++) {
//                Row row = sheet.getRow(i);
//                double id = row.getCell(0).getNumericCellValue();
//                String phone = row.getCell(1).getStringCellValue();
//                String salt = row.getCell(2).getStringCellValue();
//                String sign = row.getCell(3).getStringCellValue();
//                String headpic = row.getCell(4).getStringCellValue();
//                String name = row.getCell(5).getStringCellValue();
//                String dharma = row.getCell(6).getStringCellValue();
//                double sex = row.getCell(7).getNumericCellValue();
//                String province = row.getCell(8).getStringCellValue();
//                String city = row.getCell(9).getStringCellValue();
//                String status = row.getCell(10).getStringCellValue();
//                Date regdate = row.getCell(11).getDateCellValue();
//                User user = new User((int)id,phone,salt,sign,headpic,name,dharma,(int)sex,province,city,status,regdate);
//                System.out.println(user);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
