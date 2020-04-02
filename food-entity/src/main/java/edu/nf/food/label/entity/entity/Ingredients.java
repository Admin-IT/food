package edu.nf.food.label.entity.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 食材表
 */
@Data
public class Ingredients {
    // id
    private Integer id ;
    private String name ; // 食材姓名
    private String alias ; // 别名
    private String proposal ; //建议
    private String suitable ; //适应人群
    private String taboo; // 禁忌人群
    private String label; // 标签
    private String remarks; //标签
}