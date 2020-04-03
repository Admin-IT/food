package edu.nf.food.user.dao;

import edu.nf.food.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/3/25 14:41
 */

@Mapper
public interface UserDao {

    List<User> listUser();

    void delUserById(User user);

    void upUserById(User user);

    void addUser(User user);

    User loginUser(User user);
}
