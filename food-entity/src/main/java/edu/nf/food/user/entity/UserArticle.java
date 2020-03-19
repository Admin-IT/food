package edu.nf.food.user.entity;

import lombok.Data;

/**
 * @Author ethan
 * @Classname UserArticle
 * @Description TODO
 * @Date 2020/3/17 13:45
 */

@Data
public class UserArticle {

    private Integer userArticleId;
    private Integer userId;
    private Integer articleId;

}
