package edu.nf.food.food.web.entity;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/19
 * 回复表
 */
@Data
public class Reply {
    private Integer id;
    private Integer commentId;//绑定评论表
    private String text ; // 回复内容
    private Integer uid; // 回复ID
    private Integer lastid; // 上一条回复ID
}