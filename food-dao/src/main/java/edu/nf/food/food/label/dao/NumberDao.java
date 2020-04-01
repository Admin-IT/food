package edu.nf.food.food.label.dao;

import edu.nf.food.food.label.entity.Number;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Mapper
public interface NumberDao {
    List<Number> listNumber();

    void addNumber(Number number);

    void delNumber(Number number);
}