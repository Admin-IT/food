package edu.nf.food.user.service;

import edu.nf.food.user.entity.UserFood;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserFoodService
 * @Description TODO
 * @Date 2020/3/25 15:36
 */

public interface UserFoodService {

    List<UserFood> listUserFood();

    void delUserFoodById(UserFood userFood);

    void upUserFoodById(UserFood userFood);

    void addUserFood(UserFood userFood);
}
