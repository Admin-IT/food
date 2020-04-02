package edu.nf.food.food.dao;

import edu.nf.food.food.entity.Cuisine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname CuisineDao
 * @Description TODO
 * @Date 2020/3/25 14:30
 */

@Mapper
public interface CuisineDao {

    List<Cuisine> listCuisine();

    void delCuisineById(Cuisine cuisine);

    void upCuisineById(Cuisine cuisine);

    void addCuisine(Cuisine cuisine);
}
