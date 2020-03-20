package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.NumberDao;
import edu.nf.food.label.entity.Number;
import edu.nf.food.label.service.NumberService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Service
public class NumberServiceImpl implements NumberService {
    @Autowired
    private NumberDao dao;

    @Override
    public List<Number> listNumber() {
        try {
            return dao.listNumber();
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addNumber(Number number) {
        try {
            dao.addNumber(number);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delNumber(Number number) {
        try {
            dao.delNumber(number);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}