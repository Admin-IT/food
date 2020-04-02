package edu.nf.food.user.service;

import edu.nf.food.user.entity.UserArticle;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserArticleService
 * @Description TODO
 * @Date 2020/3/25 15:23
 */

public interface UserArticleService {

    List<UserArticle> listUserArticle();

    void delUserArticleById(UserArticle userArticle);

    void upUserArticleById(UserArticle userArticle);

    void addUserArticle(UserArticle userArticle);
}
