package edu.nf.food.user.entity;

/**
 * @Author ethan
 * @Classname Collection
 * @Description TODO
 * @Date 2020/3/17 13:38
 */

public class Collection {

    private Integer collectionId;
    private Integer userId;
    private Integer foodId;
    private Integer articleId;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
