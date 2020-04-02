package edu.nf.food.user.service;

import edu.nf.food.user.entity.UserDynamic;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserDynamicService
 * @Description TODO
 * @Date 2020/3/25 15:30
 */

public interface UserDynamicService {

    List<UserDynamic> listUserDynamic();

    void delUserDynamicById(UserDynamic userDynamic);

    void upUserDynamicById(UserDynamic userDynamic);

    void addUserDynamic(UserDynamic userDynamic);
}
