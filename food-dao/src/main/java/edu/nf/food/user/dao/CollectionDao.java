package edu.nf.food.user.dao;

import edu.nf.food.user.entity.Collection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ethan
 * @Classname CollectionDao
 * @Description TODO
 * @Date 2020/3/25 14:51
 */

@Mapper
public interface CollectionDao {

    List<Collection> listCollection();

    void delCollectionById(Collection collection);

    void upCollectionById(Collection collection);

    void addCollection(Collection collection);
}
