package edu.nf.food.food.service.impl;

import edu.nf.food.food.dao.FoodDao;
import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.food.service.exception.FoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname FoodServiceImpl
 * @Description TODO
 * @Date 2020/3/25 13:50
 * 菜谱
 */

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    /**
     * 获取菜谱列表
     * @return
     */
    @Override
    public List<Food> listFood() {
       try{
           List<Food> list = foodDao.listFood();
           return list;
       }catch (Exception e){
           throw new FoodException("获取菜谱异常：" + e);
       }
    }

    /**
     * 删除菜谱
     * @param food
     */
    @Override
    public void delFoodById(Food food) {
        try{
            foodDao.delFoodById(food);
        }catch (Exception e){
            throw new FoodException("删除菜谱异常：" + e);
        }
    }

    /**
     * 修改菜谱
     * @param food
     */
    @Override
    public void upFoodById(Food food) {
        try{
            foodDao.upFoodById(food);
        }catch (Exception e){
            throw new FoodException("修改菜谱异常：" + e);
        }
    }

    /**
     * 添加菜谱
     * @param food
     */
    @Override
    public void addFood(Food food) {
        try{
            foodDao.addFood(food);
        }catch (Exception e){
            throw new FoodException("添加菜谱异常：" + e);
        }
    }
}
