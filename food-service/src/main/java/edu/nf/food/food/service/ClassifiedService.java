package edu.nf.food.food.service;

import edu.nf.food.food.entity.Classified;

import java.util.List;

/**
 * @Author ethan
 * @Classname ClassifiedService
 * @Description TODO
 * @Date 2020/3/25 14:24
 */

public interface ClassifiedService {

    List<Classified> listClassified();

    void delClassifiedById(Classified classified);

    void upClassifiedById(Classified classified);

    void addClassified(Classified classified);
}
