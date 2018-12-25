package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Excel(name = "id")
    private Integer id;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "盐")
    private String salt;
    @Excel(name = "标识")
    private String sign;
    @Excel(name = "头像", type = 2)
    private String headpic;
    @Excel(name = "名字")
    private String name;
    @Excel(name = "法号")
    private String dharma;
    @Excel(name = "性别")
    private Integer sex;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "注册日期", format = "YYYY年MM月dd日")
    private Date regdate;
}
