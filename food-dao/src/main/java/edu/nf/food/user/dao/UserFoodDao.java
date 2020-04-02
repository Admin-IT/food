package edu.nf.food.user.dao;

import edu.nf.food.user.entity.UserFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserFoodDao
 * @Description TODO
 * @Date 2020/3/25 15:33
 */

@Mapper
public interface UserFoodDao {

    List<UserFood> listUserFood();

    void delUserFoodById(UserFood userFood);

    void upUserFoodById(UserFood userFood);

    void addUserFood(UserFood userFood);

}
