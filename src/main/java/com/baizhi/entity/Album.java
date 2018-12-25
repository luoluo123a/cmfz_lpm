package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ExcelIgnore
    private Integer id;
    @Excel(name = "标题", needMerge = true)
    private String title;
    @Excel(name = "数量")
    @ExcelIgnore
    private Integer count;//数量
    @Excel(name = "封面", type = 2, width = 40, height = 20, needMerge = true)
    private String coverimg;//封面
    @Excel(name = "评分")
    @ExcelIgnore
    private Double score;//评分
    @Excel(name = "作者")
    @ExcelIgnore
    private String author;//作者
    @Excel(name = "播音")
    @ExcelIgnore
    private String broadcast;//播音
    @Excel(name = "简介")
    @ExcelIgnore
    private String brief;//简介
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "发布日期")
    @ExcelIgnore
    private Date pubdate;//发布日期
    @ExcelCollection(name = "文章")
    @Transient
    private List<Chapter> children;
}
