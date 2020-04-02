package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.TechnologyDao;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/11
 *
 * 口艺 增删改查
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {


    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public List<Technology> listTechnology() {


        try {
            return technologyDao.listTechnology();
        } catch (Exception e) {
           throw new LabelException("数据库错误");
        }
    }

    @Override
    public void insertTechnology(Technology technology) {
        try {
            technologyDao.insertTechnology(technology);
        } catch (Exception e) {
            throw new LabelException("添加错误");
        }
    }

    @Override
    public void deleteTechnology(Technology technology) {
        try {
            technologyDao.deleteTechnology(technology);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }

}