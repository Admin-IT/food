package edu.nf.food.user.dao;

import edu.nf.food.user.entity.UserArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserArticleDao
 * @Description TODO
 * @Date 2020/3/25 15:12
 */

@Mapper
public interface UserArticleDao {

    List<UserArticle> listUserArticle();

    void delUserArticleById(UserArticle userArticle);

    void upUserArticleById(UserArticle userArticle);

    void addUserArticle(UserArticle userArticle);
}
