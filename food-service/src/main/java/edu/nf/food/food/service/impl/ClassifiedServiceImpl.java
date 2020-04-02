package edu.nf.food.food.service.impl;

import edu.nf.food.food.dao.ClassifiedDao;
import edu.nf.food.food.entity.Classified;
import edu.nf.food.food.service.ClassifiedService;
import edu.nf.food.food.service.exception.FoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname ClassifiedServiceImpl
 * @Description TODO
 * @Date 2020/3/25 14:25
 * 分类
 */
@Service
public class ClassifiedServiceImpl implements ClassifiedService {

    @Autowired
    private ClassifiedDao classifiedDao;

    /**
     * 获取分类列表
     * @return
     */
    @Override
    public List<Classified> listClassified() {
        try{
            List<Classified> list = classifiedDao.listClassified();
            return list;
        }catch (Exception e){
            throw new FoodException("获取分类异常：" + e);
        }
    }

    /**
     * 删除
     * @param classified
     */
    @Override
    public void delClassifiedById(Classified classified) {
        try{
           classifiedDao.delClassifiedById(classified);
        }catch (Exception e){
            throw new FoodException("删除分类异常：" + e);
        }
    }


    /**
     * 修改
     * @param classified
     */
    @Override
    public void upClassifiedById(Classified classified) {
        try{
            classifiedDao.upClassifiedById(classified);
        }catch (Exception e){
            throw new FoodException("修改分类异常：" + e);
        }
    }

    /**
     * 添加
     * @param classified
     */
    @Override
    public void addClassified(Classified classified) {
        try{
            classifiedDao.addClassified(classified);
        }catch (Exception e){
            throw new FoodException("添加分类异常：" + e);
        }
    }
}
