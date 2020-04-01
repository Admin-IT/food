package edu.nf.food.food.food.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 菜谱菜稿
 */
@Data
public class FoodDraft {
    private Integer id;
    private Integer foodId;//菜谱ID
    private Integer userId;//用户ID
    private String state;//状态
}