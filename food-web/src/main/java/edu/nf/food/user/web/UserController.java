package edu.nf.food.user.web;

import edu.nf.food.user.entity.User;
import edu.nf.food.user.entity.UserDynamic;
import edu.nf.food.user.service.UserDynamicService;
import edu.nf.food.user.service.UserService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserController
 * @Description TODO
 * @Date 2020/4/2 15:21
 * 用户
 */

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/list_user")
    public ResponseVO listUser(){
        List<User> list = userService.listUser();
        return success(list);
    }

    /**
     * 删除用户(暂用)
     * @param user
     * @return
     */
    @PostMapping("/del_user")
    public ResponseVO delUser(User user){
        userService.delUserById(user);
        return success("删除成功");
    }

    /**
     * 修改用户资料
     * @param user
     * @return
     */
    @PostMapping("/up_user")
    public ResponseVO upUser(User user){
        userService.upUserById(user);
        return success("修改成功");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add_user")
    public ResponseVO addUser(User user){
        userService.addUser(user);
        return success("添加成功");
    }
}
