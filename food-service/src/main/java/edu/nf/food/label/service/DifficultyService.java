package edu.nf.food.label.service;

import edu.nf.food.label.entity.Difficulty;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 难度
 */
public interface DifficultyService {
    List<Difficulty> listDifficulty();

    void addDiffculty(Difficulty difficulty);

    void delDiffculty(Difficulty difficulty);
}