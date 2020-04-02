package edu.nf.food.label.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 */
@Data
public class Label {
    private Integer id;
    private String name ;//标签名字
    private String category; //标签类别
    private String image;//标签图片
}