package edu.nf.food.user.service.impl;

import edu.nf.food.user.dao.FollowDao;
import edu.nf.food.user.entity.Follow;
import edu.nf.food.user.service.FollowService;
import edu.nf.food.user.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowServiceImpl
 * @Description TODO
 * @Date 2020/3/25 15:08
 * 关注
 */

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;

    /**
     * 获取粉丝列表
     * @return
     */
    @Override
    public List<Follow> listFollow() {
        try {
            List<Follow> list = followDao.listFollow();
            return list;
        }catch (Exception e){
            throw new UserException("获取粉丝列表异常：" + e);
        }
    }

    /**
     * 取消关注
     * @param follow
     */
    @Override
    public void delFollowById(Follow follow) {
        try {
            followDao.delFollowById(follow);
        }catch (Exception e){
            throw new UserException("取消关注异常：" + e);
        }
    }

    /**
     * 更新关注
     * @param follow
     */
    @Override
    public void upFollowById(Follow follow) {
        try {
            followDao.upFollowById(follow);
        }catch (Exception e){
            throw new UserException("更新关注异常：" + e);
        }
    }

    /**
     * 添加关注
     * @param follow
     */
    @Override
    public void addFollow(Follow follow) {
        try {
            followDao.addFollow(follow);
        }catch (Exception e){
            throw new UserException("添加关注异常：" + e);
        }
    }
}
