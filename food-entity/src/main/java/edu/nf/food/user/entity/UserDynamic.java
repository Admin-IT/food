package edu.nf.food.user.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author ethan
 * @Classname UserDynamic
 * @Description TODO
 * @Date 2020/3/17 13:47
 */

@Data
public class UserDynamic {

    private Integer userDynamicId;
    private Integer userId;
    private String dynamicContent;
    private Integer senderId;
    private Date dynamicTime;


}
