package edu.nf.food.food.user.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ethan
 * @date 2020/3/6
 */

@Data
public class User {
    private Integer userId;
    private String userName;
    private Boolean userSex;
    private Date userBirthday;
    private String  userHometown;
    private String userLocation;
    private String userOccupation;
    private String userAutograph;
    private String userEmail;
    private String userTel;
    private String userFans;
    private String userFollow;
    private String userImage;


}