package edu.nf.food.food.entity;

import lombok.Data;

/**
 * @author ethan
 * @date 2020/3/6
 */

@Data
public class Food {

    private Integer foodId;
    private String foodName;
    private String foodCuisine;
    private String foodClassified;
    private String foodTechnology;
    private String foodFlavor;
    private String foodDifficulty;
    private String foodReparationTime;
    private String foodNumber;
    private String foodCookingTime;
    private Integer foodStep;
    private Integer foodIngredients;
    private Integer foodImage;
    private Integer userId;
    private String foodIntroduce;
    private String foodLabel;
    private String foodStory;
    private String foodState;
    private String foodDate;
}