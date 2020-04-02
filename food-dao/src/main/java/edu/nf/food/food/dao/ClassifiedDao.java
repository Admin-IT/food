package edu.nf.food.food.dao;

import edu.nf.food.food.entity.Classified;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname ClassifiedDao
 * @Description TODO
 * @Date 2020/3/25 14:20
 */
@Mapper
public interface ClassifiedDao {

    List<Classified> listClassified();

    void delClassifiedById(Classified classified);

    void upClassifiedById(Classified classified);

    void addClassified(Classified classified);
}
