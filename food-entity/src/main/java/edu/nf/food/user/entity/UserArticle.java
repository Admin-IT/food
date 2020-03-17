package edu.nf.food.user.entity;

/**
 * @Author ethan
 * @Classname UserArticle
 * @Description TODO
 * @Date 2020/3/17 13:45
 */

public class UserArticle {

    private Integer userArticleId;
    private Integer userId;
    private Integer articleId;

    public Integer getUserArticleId() {
        return userArticleId;
    }

    public void setUserArticleId(Integer userArticleId) {
        this.userArticleId = userArticleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
