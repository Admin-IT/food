package edu.nf.food.food.food.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ljf
 * @date 2020/3/19
 * 步骤表
 */
@Data
public class Step {
    private Integer id;
    private Integer foodId;//菜谱ID
    private String order;// 步骤顺序
    private String nickName;// 主料或者辅料
    private String number;//用量
    private String text; //介绍
    private Date stepTime;//所需时间
}