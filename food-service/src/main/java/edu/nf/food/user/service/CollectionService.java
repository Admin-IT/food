package edu.nf.food.user.service;

import edu.nf.food.user.entity.Collection;

import java.util.List;

/**
 * @Author ethan
 * @Classname CollectionService
 * @Description TODO
 * @Date 2020/3/25 15:01
 */

public interface CollectionService {

    List<Collection> listCollection();

    void delCollectionById(Collection collection);

    void upCollectionById(Collection collection);

    void addCollection(Collection collection);
}
