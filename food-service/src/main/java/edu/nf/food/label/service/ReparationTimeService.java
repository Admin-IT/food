package edu.nf.food.label.service;

import edu.nf.food.label.entity.ReparationTime;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
public interface ReparationTimeService {
    List<ReparationTime> listReparationTime();

    void addReparationTime(ReparationTime reparationTime);

    void delReparationTime(ReparationTime ReparationTime);
}