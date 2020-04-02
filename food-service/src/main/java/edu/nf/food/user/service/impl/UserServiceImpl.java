package edu.nf.food.user.service.impl;

import edu.nf.food.user.dao.UserDao;
import edu.nf.food.user.entity.User;
import edu.nf.food.user.service.UserService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/3/25 14:48
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public List<User> listUser() {
        try {
            List<User> list = userDao.listUser();
            return list;
        }catch (Exception e){
            throw new UserException("获取用户列表异常：" + e);
        }
    }

    /**
     * 删除用户（暂用）
     * @param user
     */
    @Override
    public void delUserById(User user) {
        try {
            userDao.delUserById(user);
        }catch (Exception e){
            throw new UserException("删除用户异常：" + e);
        }
    }

    /**
     * 更新用户
     * @param user
     */
    @Override
    public void upUserById(User user) {
        try {
            userDao.upUserById(user);
        }catch (Exception e){
            throw new UserException("更新用户异常：" + e);
        }
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        }catch (Exception e){
            throw new UserException("添加用户异常：" + e);
        }
    }
}
