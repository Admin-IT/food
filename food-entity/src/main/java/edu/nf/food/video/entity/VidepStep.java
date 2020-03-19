package edu.nf.food.video.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 视频做法
 */
@Data
public class VidepStep {
    private Integer id;
    private Integer videoId;//视频ID
    private Integer foodId;//菜谱ID
    private String practice;//做法
    private Integer order;//顺序
}