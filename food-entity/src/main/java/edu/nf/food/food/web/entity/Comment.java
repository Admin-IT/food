package edu.nf.food.food.web.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 评论表
 */
@Data
public class Comment {
    private Integer id;
    private Integer uid;//绑定ID
    private String orderId; //顺序ID
}