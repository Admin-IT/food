package edu.nf.food.user.entity;

/**
 * @Author ethan
 * @Classname UserFood
 * @Description TODO
 * @Date 2020/3/17 13:41
 */

public class UserFood {

    private Integer userFoodId;
    private Integer userId;
    private Integer foodId;

    public Integer getUserFoodId() {
        return userFoodId;
    }

    public void setUserFoodId(Integer userFoodId) {
        this.userFoodId = userFoodId;
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
}
