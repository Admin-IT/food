package edu.nf.food.label.entity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ljf
 * @date 2020/3/19
 * 菜谱审核
 */
@Data
public class FoodExamine {
    private Integer id;
    private Integer foodId;//菜谱ID
    private String state;//审核状态
    private Integer adminId;//管理员
    private Date time;//审核时间
}
