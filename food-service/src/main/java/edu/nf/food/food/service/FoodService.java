package edu.nf.food.food.service;

import edu.nf.food.food.entity.Food;

import java.util.List;

/**
 * @Author ethan
 * @Classname FoodService
 * @Description TODO
 * @Date 2020/3/25 13:48
 * 菜谱
 */

public interface FoodService {

    List<Food> listFood();

    void delFoodById(Food food);

    void upFoodById(Food food);

    void addFood(Food food);
}
