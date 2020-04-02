package edu.nf.food.user.service.impl;


import edu.nf.food.user.dao.UserArticleDao;
import edu.nf.food.user.entity.UserArticle;
import edu.nf.food.user.service.UserArticleService;
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
public class UserArticleServiceImpl implements UserArticleService {

    @Autowired
    private UserArticleDao userArticleDao;

    /**
     * 获取用户文章列表
     * @return
     */
    @Override
    public List<UserArticle> listUserArticle() {
        try {
            List<UserArticle> list = userArticleDao.listUserArticle();
            return list;
        }catch (Exception e){
            throw new UserException("获取用户文章列表异常：" + e);
        }
    }

    /**
     * 删除用户文章
     * @param userArticle
     */
    @Override
    public void delUserArticleById(UserArticle userArticle) {
        try {
            userArticleDao.delUserArticleById(userArticle);
        }catch (Exception e){
            throw new UserException("删除用户文章异常：" + e);
        }
    }


    /**
     * 更新用户文章
     * @param userArticle
     */
    @Override
    public void upUserArticleById(UserArticle userArticle) {
        try {
            userArticleDao.upUserArticleById(userArticle);
        }catch (Exception e){
            throw new UserException("更新用户文章异常：" + e);
        }
    }

    /**
     * 添加用户文章
     * @param userArticle
     */
    @Override
    public void addUserArticle(UserArticle userArticle) {
        try {
            userArticleDao.addUserArticle(userArticle);
        }catch (Exception e){
            throw new UserException("添加用户文章异常：" + e);
        }
    }
}
