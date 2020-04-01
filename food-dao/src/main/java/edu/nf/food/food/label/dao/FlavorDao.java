package edu.nf.food.food.label.dao;

import edu.nf.food.food.label.entity.Flavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
@Mapper
public interface FlavorDao {
    List<Flavor> listFlaver();

    void addFlaver(Flavor flavor);

    void delFlaver(Flavor flaver);
}