package com.baizhi.controller;

import com.baizhi.dto.PageDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("queryAll")
    public List<Banner> queryAll() {
        List<Banner> banners = bannerService.queryAll();
        for (Banner banner : banners) {
            System.out.println(banner);
        }
        return banners;
    }

    @RequestMapping("insertBanner")
    public void insertBanner(Banner banner, MultipartFile fi1, HttpSession session) throws IllegalStateException, IOException {
        ServletContext ctx = session.getServletContext();
        // 上传路径
        String realPath = ctx.getRealPath("/file");
        // 目标文件
        String src = fi1.getOriginalFilename();
        File descFile = new File(realPath + "/" + src);
        banner.setImg_path("/file/" + src);
        // 上传
        fi1.transferTo(descFile);
        bannerService.insertBanner(banner);
    }

    @RequestMapping("deleteBanner")
    public void deleteBanner(Integer id) {
        bannerService.deleteBanner(id);
    }

    @RequestMapping("queryById")
    public Banner queryById(Integer id) {
        Banner banner = bannerService.queryById(id);
        return banner;
    }

    @RequestMapping("updateBanner")
    public void updateBanner(Banner banner) {
        bannerService.updateBanner(banner);
    }

    @RequestMapping("queryByPage")
    public PageDto queryByPage(int page, int rows) {
        PageDto dto = bannerService.queryByPage(page, rows);
        System.out.println(dto.getRows());
        return dto;

    }
}
