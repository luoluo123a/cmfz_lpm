package com.baizhi.dto;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDto {
    private List<Chapter> list;
    private Album introduction;
}
