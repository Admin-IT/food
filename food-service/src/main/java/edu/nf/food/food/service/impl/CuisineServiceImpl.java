package edu.nf.food.food.service.impl;

import edu.nf.food.food.dao.CuisineDao;
import edu.nf.food.food.entity.Cuisine;
import edu.nf.food.food.service.CuisineService;
import edu.nf.food.food.service.exception.FoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname CuisineServiceImpl
 * @Description TODO
 * @Date 2020/3/25 14:37
 */
@Service
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    private CuisineDao cuisineDao;

    /**
     * 获取烹饪列表
     * @return
     */
    @Override
    public List<Cuisine> listCuisine() {
        try {
            List<Cuisine> list = cuisineDao.listCuisine();
            return list;
        }catch (Exception e){
            throw new RuntimeException("获取烹饪列表异常：" + e);
        }
    }

    /**
     * 删除
     * @param cuisine
     */
    @Override
    public void delCuisineById(Cuisine cuisine) {
        try {
           cuisineDao.delCuisineById(cuisine);
        }catch (Exception e){
            throw new RuntimeException("删除异常：" + e);
        }
    }

    /**
     * 修改
     * @param cuisine
     */
    @Override
    public void upCuisineById(Cuisine cuisine) {
        try {
            cuisineDao.upCuisineById(cuisine);
        }catch (Exception e){
            throw new RuntimeException("修改异常：" + e);
        }
    }

    /**
     * 添加
     * @param cuisine
     */
    @Override
    public void addCuisine(Cuisine cuisine) {
        try {
            cuisineDao.addCuisine(cuisine);
        }catch (Exception e){
            throw new FoodException("添加异常：" + e);
        }
    }
}
