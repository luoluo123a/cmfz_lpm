package com.baizhi.dto;

import com.baizhi.entity.Banner;

import java.io.Serializable;
import java.util.List;

public class PageDto implements Serializable {
    private Integer total;
    private List<Banner> rows;

    public PageDto() {
    }

    public PageDto(Integer total, List<Banner> rows) {
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }
}
