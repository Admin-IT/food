package edu.nf.food.food.service;

import edu.nf.food.food.entity.Cuisine;

import java.util.List;

/**
 * @Author ethan
 * @Classname CuisineService
 * @Description TODO
 * @Date 2020/3/25 14:36
 */

public interface CuisineService {

    List<Cuisine> listCuisine();

    void delCuisineById(Cuisine cuisine);

    void upCuisineById(Cuisine cuisine);

    void addCuisine(Cuisine cuisine);
}
