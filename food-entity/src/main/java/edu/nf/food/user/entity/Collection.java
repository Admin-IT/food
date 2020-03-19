package edu.nf.food.user.entity;

import lombok.Data;

/**
 * @Author ethan
 * @Classname Collection
 * @Description TODO
 * @Date 2020/3/17 13:38
 */

@Data
public class Collection {

    private Integer collectionId;
    private Integer userId;
    private Integer foodId;
    private Integer articleId;

}
