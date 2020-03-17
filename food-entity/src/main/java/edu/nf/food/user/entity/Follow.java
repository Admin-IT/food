

package edu.nf.food.user.entity;

/**
 * @Author ethan
 * @Classname Follow
 * @Description TODO
 * @Date 2020/3/17 13:29
 */

public class Follow {

    private Integer followId;
    private Integer follow;
    private Integer userId;

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
