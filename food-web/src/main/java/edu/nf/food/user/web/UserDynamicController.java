package edu.nf.food.user.web;

import edu.nf.food.user.entity.UserDynamic;
import edu.nf.food.user.service.UserDynamicService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserDynamicController
 * @Description TODO
 * @Date 2020/4/2 15:10
 * 用户动态
 */

@RestController
public class UserDynamicController extends BaseController {

    @Autowired
    private UserDynamicService userDynamicService;

    /**
     * 获取用户动态列表
     * @return
     */
    @GetMapping("/list_userDynamic")
    public ResponseVO listUserDynamic(){
        List<UserDynamic> list = userDynamicService.listUserDynamic();
        return success(list);
    }

    /**
     * 删除用户动态
     * @param userDynamic
     * @return
     */
    @PostMapping("/del_userDynamic")
    public ResponseVO delUserDynamic(UserDynamic userDynamic){
        userDynamicService.delUserDynamicById(userDynamic);
        return success("删除成功");
    }

    /**
     * 修改用户动态
     * @param userDynamic
     * @return
     */
    @PostMapping("/up_userDynamic")
    public ResponseVO upUserDynamic(UserDynamic userDynamic){
        userDynamicService.upUserDynamicById(userDynamic);
        return success("修改成功");
    }

    /**
     * 添加用户动态
     * @param userDynamic
     * @return
     */
    @PostMapping("/add_userDynamic")
    public ResponseVO addUserDynamic(UserDynamic userDynamic){
        userDynamicService.addUserDynamic(userDynamic);
        return success("添加成功");
    }
}
