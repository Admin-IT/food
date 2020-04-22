package edu.nf.food.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ethan
 * @date 2020/3/6
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Field(type = FieldType.Integer, analyzer = "ik_max_word")
    private Integer foodId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodName;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodCuisine;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodClassified;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodTechnology;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodFlavor;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodDifficulty;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodReparationTime;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodNumber;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodCookingTime;
    @Field(type = FieldType.Integer, analyzer = "ik_max_word")
    private Integer foodStep;
    @Field(type = FieldType.Integer, analyzer = "ik_max_word")
    private Integer foodIngredients;
    @Field(type = FieldType.Integer, analyzer = "ik_max_word")
    private Integer foodImage;
    @Field(type = FieldType.Integer, analyzer = "ik_max_word")
    private Integer userId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodIntroduce;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodLabel;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodStory;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodState;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String foodDate;
}