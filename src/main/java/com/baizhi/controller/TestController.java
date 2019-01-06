package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("query")
    public Object test(String uid, String type, String sub_type) {
        if (uid == null || type == null) {
            return new Error("参数不能为空");
        } else {
            if (type.equals("all")) {
                Map<String, Object> map = new HashMap<>();
                map.put("banner", "轮播图集合");
                map.put("album", "专辑集合");
                map.put("article", "文章集合");
                return map;
            } else if (type.equals("wen")) {
                Map<String, Object> map = new HashMap<>();
                map.put("album", "专辑集合");
                return map;
            } else {
                if (sub_type != null) {
                    if (sub_type.equals("ssyj")) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("album", "上师的文章集合");
                        return map;
                    } else {
                        Map<String, Object> map = new HashMap<>();
                        map.put("album", "其他上师的文章集合");
                        return map;
                    }

                } else {
                    return new Error("思的类型不能为空");
                }
            }
        }
    }
}
