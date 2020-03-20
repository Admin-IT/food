package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.CookTimeDao;
import edu.nf.food.label.entity.CookTime;
import edu.nf.food.label.service.CookTimeService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Service
public class CookTimeImpl implements CookTimeService {
    @Autowired
    private CookTimeDao dao;

    @Override
    public List<CookTime> listCookTime() {
        try {
            return dao.listCookTime();
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addCookTime(CookTime cookTime) {
        try {
            dao.addCookTime(cookTime);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delCookTime(CookTime cookTime) {
        try {
            dao.delCookTime(cookTime);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}