package edu.nf.food.food.dao;

import edu.nf.food.food.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname FoodDao
 * @Description TODO
 * @Date 2020/3/25 13:30
 */
@Mapper
public interface FoodDao {

    List<Food> listFood();

    void delFoodById(Food food);

    void upFoodById(Food food);

    void addFood(Food food);
}
