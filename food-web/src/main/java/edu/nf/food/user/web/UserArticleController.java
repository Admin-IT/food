package edu.nf.food.user.web;

import edu.nf.food.user.entity.UserArticle;
import edu.nf.food.user.service.UserArticleService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname UserArticleController
 * @Description TODO
 * @Date 2020/4/2 15:05
 * 用户文章
 */

@RestController
public class UserArticleController extends BaseController {

    @Autowired
    private UserArticleService userArticleService;

    /**
     * 获取用户文章列表
     * @return
     */
    @GetMapping("/list_userArticle")
    public ResponseVO listUserArticle(){
        List<UserArticle> list = userArticleService.listUserArticle();
        return success(list);
    }

    /**
     * 删除用户文章
     * @param userArticle
     * @return
     */
    @PostMapping("/del_userArticle")
    public ResponseVO delUserArticle(UserArticle userArticle){
        userArticleService.delUserArticleById(userArticle);
        return success("删除成功");
    }

    /**
     * 修改用户文章
     * @param userArticle
     * @return
     */
    @PostMapping("/up_userArticle")
    public ResponseVO upUserArticle(UserArticle userArticle){
        userArticleService.upUserArticleById(userArticle);
        return success("修改成功");
    }

    /**
     * 添加用户文章
     * @param userArticle
     * @return
     */
    @PostMapping("/add_userArticle")
    public ResponseVO addUserArticle(UserArticle userArticle){
        userArticleService.addUserArticle(userArticle);
        return success("添加成功");
    }
}
