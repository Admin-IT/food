package edu.nf.food.user.service.impl;


import edu.nf.food.user.dao.UserFoodDao;
import edu.nf.food.user.entity.UserFood;
import edu.nf.food.user.service.UserFoodService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowServiceImpl
 * @Description TODO
 * @Date 2020/3/25 15:08
 * 用户菜谱
 */

@Service
public class UserFoodServiceImpl implements UserFoodService {

    @Autowired
    private UserFoodDao userFoodDao;

    /**
     * 获取用户菜谱列表
     * @return
     */
    @Override
    public List<UserFood> listUserFood() {
        try {
            List<UserFood> list = userFoodDao.listUserFood();
            return list;
        }catch (Exception e){
            throw new UserException("获取用户菜谱列表异常：" + e);
        }
    }

    /**
     * 删除用户菜谱
     * @param userFood
     */
    @Override
    public void delUserFoodById(UserFood userFood) {
        try {
            userFoodDao.delUserFoodById(userFood);
        }catch (Exception e){
            throw new UserException("删除用户菜谱异常：" + e);
        }
    }

    /**
     * 修改用户菜谱
     * @param userFood
     */
    @Override
    public void upUserFoodById(UserFood userFood) {
        try {
            userFoodDao.upUserFoodById(userFood);
        }catch (Exception e){
            throw new UserException("修改用户菜谱异常：" + e);
        }
    }

    /**
     * 添加用户菜谱
     * @param userFood
     */
    @Override
    public void addUserFood(UserFood userFood) {
        try {
            userFoodDao.addUserFood(userFood);
        }catch (Exception e){
            throw new UserException("添加用户菜谱异常：" + e);
        }
    }
}
