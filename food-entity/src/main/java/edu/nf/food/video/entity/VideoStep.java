package edu.nf.food.video.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 视频做法
 */
@Data
public class VideoStep {
    private Integer id;
    private Integer videoId;//视频ID
    private String method;//做法内容介绍
    private Video video;//关联video的视频ID
}