package com.baizhi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baizhi.dto.AlbumPage;
import com.baizhi.dto.BusiParams;
import com.baizhi.dto.Params;
import com.baizhi.dto.SysParams;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
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

    @RequestMapping("getSign")
    public JSONObject getSign() throws Exception{
        Params params = new Params();
        BusiParams busiparams = new BusiParams();
        SysParams sysparams = new SysParams();
        sysparams.setBusiCode("UIP_IMAGE_CONTRAS");
        sysparams.setBusiSerial("100220181126164001000001");
        sysparams.setFormat("json");
        sysparams.setSign("TSUu7Zkvz92bNv06ajbc0tG1u56bujic2Uwsy2UmguQufaqD+sWsSvXzdEKAfF9O8q1I/OeRuiEX2WAYJKlfsOET8oGnOtCn4Icf68hdPZAMKGk8Q1f7I0BDCAmB6WSd1o3pTU+9L5GAuE/hds075V/crkPO1Z+/KxFWcStRMxEcvIzuTLZEeXtjjujuX4kXrBkF462yZHPq6mSlBJn2+AbIud7w0PieMh3o5jsLvrRY3smmk3gZo9ciR+1ST/C7C1lvDIBKA+IJo0ijMRbH8QNMxCuxkJTYsz0K4SOG8A5gcQJHk3SC1wWKQvsGofOIXzz6/vUDw1ACsHTwCYMNfg==");
        sysparams.setSourceId("1002");
        busiparams.setBillId("13838245229");
        busiparams.setCustCertNo("dc100ac0790a6e204d449c72427d34b78e88df134a310a25");
        busiparams.setCustName("300859b8a5bdd109");
        params.setBusiparams(busiparams);
        params.setSysparams(sysparams);
        String json = JSON.toJSONString(params);
        String url = "https://www.ha.10086.cn/uip/open/api";
        JSONObject jsonObject = this.doPostHttpRequestNew(url, json);
//        AlbumPage dto = albumService.queryByPage(page, rows);
//        System.out.println(dto.getRows());
        return jsonObject;

    }


    public  JSONObject doPostHttpRequestNew(String url, String json)
            throws Exception {

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);// POST请求
        String responseMsg = "";
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        postMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
//		postMethod.setRequestBody(String.valueOf(jsonObject));
        RequestEntity requestEntity = new StringRequestEntity(json,"application/json", "UTF-8");
        postMethod.setRequestEntity(requestEntity);
        try {
            int statusCode = httpClient.executeMethod(postMethod);// 发送请求
            if (statusCode == HttpStatus.SC_OK) {
                // 读取内容
                byte[] responseBody = postMethod.getResponseBody();
                // 处理返回的内容
                responseMsg = new String(responseBody, "utf-8");
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();// 关闭连接
        }
        return JSONObject.parseObject(responseMsg);
    }

}
