package edu.nf.food.article.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ljf
 * @date 2020/3/19
 * 文章审核表
 */
@Data
public class ArticleExamine {
    private Integer id;
    private Integer articleId;//文章ID
    private String state;//状态
    private String adminId;//管理员
    private Date time;//时间
}