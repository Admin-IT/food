package edu.nf.food.food.entity;

/**
 * @Author ethan
 * @Classname Cuisine
 * @Description TODO
 * @Date 2020/3/17 14:35
 */

public class Cuisine {

    private Integer cuisineId;
    private String cuisineName;

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
}
