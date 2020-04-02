package edu.nf.food.article.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 文章草稿
 */
@Data
public class ArticleDraft {
    private Integer id;
    private Integer articleId;//文章ID
    private Integer userId;//用户ID
    private String state;//状态

}