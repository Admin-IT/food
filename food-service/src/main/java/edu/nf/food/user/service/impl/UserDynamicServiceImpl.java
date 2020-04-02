package edu.nf.food.user.service.impl;


import edu.nf.food.user.dao.UserDynamicDao;
import edu.nf.food.user.entity.UserDynamic;
import edu.nf.food.user.service.UserDynamicService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowServiceImpl
 * @Description TODO
 * @Date 2020/3/25 15:08
 */

@Service
public class UserDynamicServiceImpl implements UserDynamicService {

    @Autowired
    private UserDynamicDao userDynamicDao;

    /**
     * 获取用户动态列表
     * @return
     */
    @Override
    public List<UserDynamic> listUserDynamic() {
        try {
            List<UserDynamic> list = userDynamicDao.listUserDynamic();
            return list;
        }catch (Exception e){
            throw new UserException("获取用户动态列表异常：" + e);
        }
    }

    /**
     * 删除用户动态
     * @param userDynamic
     */
    @Override
    public void delUserDynamicById(UserDynamic userDynamic) {
        try {
            userDynamicDao.delUserDynamicById(userDynamic);
        }catch (Exception e){
            throw new UserException("删除用户动态异常：" + e);
        }
    }

    /**
     * 修改用户动态
     * @param userDynamic
     */
    @Override
    public void upUserDynamicById(UserDynamic userDynamic) {
        try {
            userDynamicDao.upUserDynamicById(userDynamic);
        }catch (Exception e){
            throw new UserException("修改用户动态异常：" + e);
        }
    }

    /**
     * 添加用户动态
     * @param userDynamic
     */
    @Override
    public void addUserDynamic(UserDynamic userDynamic) {
        try {
            userDynamicDao.addUserDynamic(userDynamic);
        }catch (Exception e){
            throw new UserException("添加用户动态异常：" + e);
        }
    }
}
