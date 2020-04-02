package edu.nf.food.user.service.impl;

import edu.nf.food.user.dao.CollectionDao;
import edu.nf.food.user.entity.Collection;
import edu.nf.food.user.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ethan
 * @Classname CollectionServiceImpl
 * @Description TODO
 * @Date 2020/3/25 15:02
 */

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionDao collectionDao;

    /**
     * 获取收藏列表
     * @return
     */
    @Override
    public List<Collection> listCollection() {
        try {
            List<Collection> list = collectionDao.listCollection();
            return list;
        }catch (Exception e){
            throw new RuntimeException("获取收藏列表异常：" + e);
        }
    }

    /**
     * 取消收藏
     * @param collection
     */
    @Override
    public void delCollectionById(Collection collection) {
        try {
            collectionDao.delCollectionById(collection);
        } catch (Exception e) {
            throw new RuntimeException("取消收藏异常：" + e);
        }
    }

    /**
     * 更新收藏
     * @param collection
     */
    @Override
    public void upCollectionById(Collection collection) {
        try {
            collectionDao.upCollectionById(collection);
        } catch (Exception e) {
            throw new RuntimeException("更新收藏异常：" + e);
        }
    }

    /**
     * 添加收藏
     * @param collection
     */
    @Override
    public void addCollection(Collection collection) {
        try {
            collectionDao.addCollection(collection);
        } catch (Exception e) {
            throw new RuntimeException("添加收藏异常：" + e);
        }
    }
}
