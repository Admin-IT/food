package edu.nf.food.user.dao;

import edu.nf.food.user.entity.UserDynamic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserDynamicDao
 * @Description TODO
 * @Date 2020/3/25 15:26
 */

@Mapper
public interface UserDynamicDao {

    List<UserDynamic> listUserDynamic();

    void delUserDynamicById(UserDynamic userDynamic);

    void upUserDynamicById(UserDynamic userDynamic);

    void addUserDynamic(UserDynamic userDynamic);
}
