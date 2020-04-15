package edu.nf.food.food.web;

import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljf
 * @date 2020/4/7
 * 菜谱
 */
@RestController
public class FoodController extends BaseController {
    @GetMapping("/backstage/test")
    public ResponseVO test() {
        return success("测试");
    }
}