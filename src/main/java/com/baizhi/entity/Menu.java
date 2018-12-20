package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    //    private Integer id;
//    private String title;
//    private String iconcls;
//    private String url;
//    private Integer parent_id;
    @Id
    private Integer id;
    private String title;
    private String iconcls;
    //跳转路径
    private String url;
    // private Integer parentId;
    private List<Menu> list;
}
