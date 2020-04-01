package edu.nf.food.food.label.service.impl;

import edu.nf.food.food.label.dao.DifficultyDao;
import edu.nf.food.food.label.entity.Difficulty;
import edu.nf.food.food.label.service.DifficultyService;
import edu.nf.food.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 难度
 */
@Service
public class DifficultyServiceImpl implements DifficultyService {

      @Autowired
      private DifficultyDao dao;

    @Override
    public List<Difficulty> listDifficulty() {
        try {
           return dao.listDiffculty();
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addDiffculty(Difficulty difficulty) {
        try {
            dao.addDiffculty(difficulty);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delDiffculty(Difficulty difficulty) {
        try {
            dao.delDiffculty(difficulty);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}