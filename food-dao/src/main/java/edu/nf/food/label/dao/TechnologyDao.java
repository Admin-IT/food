package edu.nf.food.label.dao;

import edu.nf.food.label.entity.Technology;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/11
 * 口艺  增删查改
 */
@Mapper
public interface TechnologyDao {
     List<Technology> listTechnology();

     void insertTechnology(Technology technology);

     void deleteTechnology(Technology technology);
}