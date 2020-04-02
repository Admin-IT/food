package edu.nf.food.food.web;

import edu.nf.food.food.entity.Classified;
import edu.nf.food.food.entity.Cuisine;
import edu.nf.food.food.service.ClassifiedService;
import edu.nf.food.food.service.CuisineService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname CuisineController
 * @Description TODO
 * @Date 2020/4/2 14:24
 * 烹饪
 */

@RestController
public class CuisineController extends BaseController {

    @Autowired
    private CuisineService cuisineService;

    /**
     * 获取烹饪标签列表
     * @return
     */
    @GetMapping("/list_cuisine")
    public ResponseVO listCuisine(){
        List<Cuisine> list = cuisineService.listCuisine();
        return success(list);
    }

    /**
     * 删除烹饪标签
     * @param cuisine
     * @return
     */
    @PostMapping("/del_cuisine")
    public ResponseVO delCuisine(Cuisine cuisine){
        cuisineService.delCuisineById(cuisine);
        return success("删除成功");
    }

    /**
     * 更新烹饪标签
     * @param cuisine
     * @return
     */
    @PostMapping("/up_cuisine")
    public ResponseVO upCuisine(Cuisine cuisine){
        cuisineService.upCuisineById(cuisine);
        return success("更新成功");
    }

    /**
     * 添加烹饪标签
     * @param cuisine
     * @return
     */
    @PostMapping("/add_cuisine")
    public ResponseVO addCuisine(Cuisine cuisine){
        cuisineService.addCuisine(cuisine);
        return success("添加成功");
    }
}
