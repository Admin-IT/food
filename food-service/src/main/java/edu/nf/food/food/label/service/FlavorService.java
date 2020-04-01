package edu.nf.food.food.label.service;

import edu.nf.food.food.label.entity.Flavor;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
public interface FlavorService {
    List<Flavor> listFlavor();

    void addFlavor(Flavor flavor);

    void delFlavor(Flavor flavor);
}