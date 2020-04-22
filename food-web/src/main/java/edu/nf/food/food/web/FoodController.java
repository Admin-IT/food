package edu.nf.food.food.web;

import edu.nf.food.food.service.FoodService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ljf
 * @date 2020/4/7
 * 菜谱
 */
@RestController
public class FoodController extends BaseController {
//    @GetMapping("/backstage/test")
//    public ResponseVO test() {
//        return success("测试");
//    }

    @Autowired
    private FoodService service;

    /**
     * 进行搜索
     *
     * @param keyword 参数
     * @return
     * @throws Exception
     */
    @GetMapping("/search/{keyword}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword
    ) throws Exception {

        System.out.println(keyword);
        return service.searchPageHighlighter(keyword, 1, 20);
    }

    /**
     * 爬取网页数据
     *
     * @param keyword 参数关键字
     * @return
     * @throws Exception
     */
    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws Exception {
        System.out.println(keyword);
        return service.parseContent(keyword);
    }
}