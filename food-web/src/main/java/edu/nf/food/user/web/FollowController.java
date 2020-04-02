package edu.nf.food.user.web;

import edu.nf.food.user.entity.Collection;
import edu.nf.food.user.entity.Follow;
import edu.nf.food.user.service.CollectionService;
import edu.nf.food.user.service.FollowService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname FollowController
 * @Description TODO
 * @Date 2020/4/2 15:00
 * 关注
 */

@RestController
public class FollowController extends BaseController {

    @Autowired
    private FollowService followService;

    /**
     * 获取粉丝列表
     * @return
     */
    @GetMapping("/list_follow")
    public ResponseVO listFollow(){
        List<Follow> list = followService.listFollow();
        return success(list);
    }

    /**
     * 取消关注
     * @param follow
     * @return
     */
    @PostMapping("/del_follow")
    public ResponseVO delFollow(Follow follow){
        followService.delFollowById(follow);
        return success("删除成功");
    }

    /**
     * 修改关注
     * @param follow
     * @return
     */
    @PostMapping("/up_follow")
    public ResponseVO upFollow(Follow follow){
        followService.upFollowById(follow);
        return success("修改成功");
    }

    /**
     * 添加关注
     * @param follow
     * @return
     */
    @PostMapping("/add_follow")
    public ResponseVO addFollow(Follow follow){
        followService.addFollow(follow);
        return success("添加成功");
    }
}
