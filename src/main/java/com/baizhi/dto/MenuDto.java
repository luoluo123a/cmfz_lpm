package com.baizhi.dto;


import com.baizhi.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Integer id;
    private String iconcls;
    private String name;
    private List<Menu> list;

}
