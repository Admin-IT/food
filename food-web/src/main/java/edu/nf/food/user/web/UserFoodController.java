package edu.nf.food.user.web;

import edu.nf.food.user.entity.UserFood;
import edu.nf.food.user.service.UserFoodService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserFoodController
 * @Description TODO
 * @Date 2020/4/2 15:15
 * 用户菜谱
 */

@RestController
public class UserFoodController extends BaseController {

    @Autowired
    private UserFoodService userFoodService;

    /**
     * 获取用户菜谱列表
     * @return
     */
    @GetMapping("/list_userFood")
    public ResponseVO listUserFood(){
        List<UserFood> list = userFoodService.listUserFood();
        return success(list);
    }

    /**
     * 删除用户动态
     * @param userFood
     * @return
     */
    @PostMapping("/del_userFood")
    public ResponseVO delUserFood(UserFood userFood){
        userFoodService.delUserFoodById(userFood);
        return success("删除成功");
    }

    /**
     * 修改用户动态
     * @param userFood
     * @return
     */
    @PostMapping("/up_userFood")
    public ResponseVO upUserFood(UserFood userFood){
        userFoodService.upUserFoodById(userFood);
        return success("修改成功");
    }

    /**
     * 添加用户动态
     * @param userFood
     * @return
     */
    @PostMapping("/add_userFood")
    public ResponseVO addUserFood(UserFood userFood){
        userFoodService.addUserFood(userFood);
        return success("添加成功");
    }
}
