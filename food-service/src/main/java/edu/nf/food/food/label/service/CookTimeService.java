package edu.nf.food.food.label.service;

import edu.nf.food.food.label.entity.CookTime;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
public interface CookTimeService {
    List<CookTime> listCookTime();

    void addCookTime(CookTime cookTime);

    void delCookTime(CookTime cookTime);
}