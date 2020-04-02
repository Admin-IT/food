package edu.nf.food.user.service;

import edu.nf.food.user.entity.Follow;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowService
 * @Description TODO
 * @Date 2020/3/25 15:08
 */

public interface FollowService {

    List<Follow> listFollow();

    void delFollowById(Follow follow);

    void upFollowById(Follow follow);

    void addFollow(Follow follow);
}
