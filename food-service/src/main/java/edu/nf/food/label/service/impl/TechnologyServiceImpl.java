package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.TechnologyDao;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
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


       return technologyDao.listTechnology();
    }
}