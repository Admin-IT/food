package edu.nf.food.label.service;

import edu.nf.food.label.dao.CookTimeDao;
import edu.nf.food.label.entity.CookTime;

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