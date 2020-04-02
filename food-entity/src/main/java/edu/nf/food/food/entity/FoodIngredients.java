package edu.nf.food.food.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 原材料表
 */
@Data
public class FoodIngredients {
    private Integer id;
    private Integer foodId;//菜谱ID
    private String name; //材料名称
    private String number;//用料
    private String nickName;//分类
}