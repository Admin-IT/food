package edu.nf.food.message.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @date 2020/3/6
 * 消息推送表
 */
@Data
public class Message {
    private Integer id;
    private Integer adminId;//推送人
    private String content;//推送内容
    private Integer userId;//用户
    private Date time;//推送时间
    private String file;//附件
}