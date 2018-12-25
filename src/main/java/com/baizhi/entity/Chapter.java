package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    @Excel(name = "id")
    private String id;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "大小")
    private Double size;//大小
    @Excel(name = "时长")
    private String duration;//时长
    @Excel(name = "资源路径")
    private String url;//资源路径
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "上传时间", format = "YYYY年MM月dd日", width = 20)
    private Date upddate;//上传时间
    @Excel(name = "所属专辑id")
    private Integer albumid;//所属专辑id
}
