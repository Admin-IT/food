package edu.nf.food.food.video.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ljf
 * @date 2020/3/6
 * 菜谱视频
 */
@Data
public class Video {
    private Integer id;
    private String name;//视频名称
    private String label;//视频标签
    private String classified;//视频分类
    private Integer userId;//上传者
    private Date time;//上传时间
    private String number;//播放量
}