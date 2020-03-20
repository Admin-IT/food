package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.ReparationTimeDao;
import edu.nf.food.label.entity.ReparationTime;
import edu.nf.food.label.service.ReparationTimeService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Service
public class ReparationTimeServiceImpl implements ReparationTimeService {
    @Autowired
    private ReparationTimeDao dao;

    @Override
    public List<ReparationTime> listReparationTime() {
        try {
            return dao.listReparationTime();
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addReparationTime(ReparationTime reparationTime) {
        try {
            dao.addReparationTime(reparationTime);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delReparationTime(ReparationTime reparationTime) {
        try {
            dao.delReparationTime(reparationTime);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}