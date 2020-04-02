package edu.nf.food.user.dao;

import edu.nf.food.user.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowDao
 * @Description TODO
 * @Date 2020/3/25 15:05
 */

@Mapper
public interface FollowDao {

    List<Follow> listFollow();

    void delFollowById(Follow follow);

    void upFollowById(Follow follow);

    void addFollow(Follow follow);

}
