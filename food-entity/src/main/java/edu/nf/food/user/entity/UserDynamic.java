package edu.nf.food.user.entity;

import java.util.Date;

/**
 * @Author ethan
 * @Classname UserDynamic
 * @Description TODO
 * @Date 2020/3/17 13:47
 */

public class UserDynamic {

    private Integer userDynamicId;
    private Integer userId;
    private String dynamicContent;
    private Integer senderId;
    private Date dynamicTime;

    public Integer getUserDynamicId() {
        return userDynamicId;
    }

    public void setUserDynamicId(Integer userDynamicId) {
        this.userDynamicId = userDynamicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDynamicContent() {
        return dynamicContent;
    }

    public void setDynamicContent(String dynamicContent) {
        this.dynamicContent = dynamicContent;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Date getDynamicTime() {
        return dynamicTime;
    }

    public void setDynamicTime(Date dynamicTime) {
        this.dynamicTime = dynamicTime;
    }
}
