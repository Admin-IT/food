package edu.nf.food.food.web;

import edu.nf.food.food.entity.Cuisine;
import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.CuisineService;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname FoodController
 * @Description TODO
 * @Date 2020/4/2 14:28
 * 菜谱
 */


@RestController
public class FoodController extends BaseController {

    @Autowired
    private FoodService foodService;

    /**
     * 获取菜谱列表
     * @return
     */
    @GetMapping("/list_food")
    public ResponseVO listFood(){
        List<Food> list = foodService.listFood();
        return success(list);
    }

    /**
     * 删除菜谱
     * @param food
     * @return
     */
    @PostMapping("/del_food")
    public ResponseVO delFood(Food food){
        foodService.delFoodById(food);
        return success("删除成功");
    }

    /**
     * 更新菜谱
     * @param food
     * @return
     */
    @PostMapping("/up_food")
    public ResponseVO upFood(Food food){
        foodService.upFoodById(food);
        return success("更新成功");
    }

    /**
     * 添加菜谱
     * @param food
     * @return
     */
    @PostMapping("/add_food")
    public ResponseVO addFood(Food food){
        foodService.addFood(food);
        return success("添加成功");
    }
}
