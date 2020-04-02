package edu.nf.food.vo;

import lombok.Data;

/**
 * @author ljf
 * @date 2020/3/20
 * 自定义返回数据
 */
@Data
public class ResponseVO<T> {
   private Integer code;//响应类型
   private Object message;//返回信息
    private T data;

}