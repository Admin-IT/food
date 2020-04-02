package edu.nf.food.article.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ljf
 * @date 2020/3/6
 */
@Data
public class Article {
    private Integer id;
    private String title; //标签
    private String content; //内容
    private String image ;// 图片
    private Integer uid; // 作者ID
    private Date time; // 上传时间
    private String state; // 审核状态
    private String classified; // 审核后添加标签
}