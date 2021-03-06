package edu.nf.food.label.service;

import edu.nf.food.label.entity.Number;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
public interface NumberService {
    List<Number> listNumber();

    void addNumber(Number number);

    void delNumber(Number number);
}