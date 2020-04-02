package edu.nf.food.user.web;

import edu.nf.food.user.entity.Collection;
import edu.nf.food.user.service.CollectionService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname CollectionController
 * @Description TODO
 * @Date 2020/4/2 14:44
 * 收藏
 */

@RestController
public class CollectionController extends BaseController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 获取收藏列表
     * @return
     */
    @GetMapping("/list_collection")
    public ResponseVO listCollection(){
        List<Collection> list = collectionService.listCollection();
        return success(list);
    }

    /**
     * 取消收藏
     * @param collection
     * @return
     */
    @PostMapping("/del_collection")
    public ResponseVO delCollection(Collection collection){
        collectionService.delCollectionById(collection);
        return success("删除成功");
    }

    /**
     * 更新收藏
     * @param collection
     * @return
     */
    @PostMapping("/up_collection")
    public ResponseVO upCollection(Collection collection){
        collectionService.upCollectionById(collection);
        return success("更新成功");
    }

    /**
     * 添加收藏
     * @param collection
     * @return
     */
    @PostMapping("/add_collection")
    public ResponseVO addCollection(Collection collection){
        collectionService.addCollection(collection);
        return success("添加成功");
    }
}
