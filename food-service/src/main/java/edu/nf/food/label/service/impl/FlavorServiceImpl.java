package edu.nf.food.label.service.impl;

import edu.nf.food.label.dao.FlavorDao;
import edu.nf.food.label.entity.Flavor;
import edu.nf.food.label.service.FlavorService;
import edu.nf.food.label.service.exception.LabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
@Service
public class FlavorServiceImpl  implements FlavorService {
    @Autowired
    private FlavorDao dao;

    @Override
    public List<Flavor> listFlavor() {
        try {
            return dao.listFlaver();
        } catch (Exception e) {
            throw new LabelException("数据库错误");
        }
    }

    @Override
    public void addFlavor(Flavor flavor) {
        try {
            dao.addFlaver(flavor);
        } catch (Exception e) {
            throw new LabelException("添加失败");
        }
    }

    @Override
    public void delFlavor(Flavor flavor) {
        try {
            dao.delFlaver(flavor);
        } catch (Exception e) {
            throw new LabelException("删除失败");
        }
    }
}