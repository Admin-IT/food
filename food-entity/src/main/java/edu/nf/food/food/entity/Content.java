package edu.nf.food.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ljf
 * @date 2020/4/16
 * 需要的相关数据   可扩展
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String img;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String price;
}