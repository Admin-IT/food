package edu.nf.food.food.web;

import edu.nf.food.food.entity.Classified;
import edu.nf.food.food.service.ClassifiedService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ethan
 * @Classname ClassifiedController
 * @Description TODO
 * @Date 2020/4/2 14:03
 * 分类
 */

@RestController
public class ClassifiedController extends BaseController {

    @Autowired
    private ClassifiedService classifiedService;

    /**
     * 获取分类列表
     * @return
     */
    @GetMapping("/list_classified")
    public ResponseVO listClassified(){
        List<Classified> list = classifiedService.listClassified();
        return success(list);
    }

    /**
     * 删除分类
     * @param classified
     * @return
     */
    @PostMapping("/del_classified")
    public ResponseVO delClassified(Classified classified){
        classifiedService.delClassifiedById(classified);
        return success("删除成功");
    }

    /**
     * 更新分类
     * @param classified
     * @return
     */
    @PostMapping("/up_classified")
    public ResponseVO upClassified(Classified classified){
        classifiedService.upClassifiedById(classified);
        return success("更新成功");
    }

    /**
     * 添加分类
     * @param classified
     * @return
     */
    @PostMapping("/add_classified")
    public ResponseVO addClassified(Classified classified){
        classifiedService.addClassified(classified);
        return success("添加成功");
    }
}
