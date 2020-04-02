package edu.nf.food.label.dao;

import edu.nf.food.label.entity.ReparationTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@Mapper
public interface ReparationTimeDao {
    List<ReparationTime> listReparationTime();

    void addReparationTime(ReparationTime reparationTime);

    void delReparationTime(ReparationTime ReparationTime);
}