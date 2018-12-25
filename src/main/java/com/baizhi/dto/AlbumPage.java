package com.baizhi.dto;

import com.baizhi.entity.Album;

import java.io.Serializable;
import java.util.List;

public class AlbumPage implements Serializable {
    private Integer total;
    private List<Album> rows;

    public AlbumPage() {
    }

    public AlbumPage(Integer total, List<Album> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }
}
