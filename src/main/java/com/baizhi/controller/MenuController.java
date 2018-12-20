package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("queryAll")
    public List<Menu> queryAll() {
        return menuService.queryAll();
    }

    @RequestMapping("queryById")
    public List<Menu> queryById(String id) {
        return menuService.queryById(id);
    }
}
