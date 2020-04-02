package edu.nf.food.label.web;

import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 */
@RestController
public class TechnologyController extends BaseController {

    @Autowired
    private TechnologyService service;

    /**
     * 标签：获取工艺全部信息
     * @return
     */
    @GetMapping("/list_technology")
    public ResponseVO listTechnology(){
        List<Technology> technologies = service.listTechnology();
        return success(technologies);
  }

    /**
     * 标签：添加工艺
     * @param technology
     * @return
     */
    @PostMapping("/insert_technology")
    public ResponseVO insertTechnology(Technology technology){
        service.insertTechnology(technology);
        return success("添加成功");
    }


    /**
     * 标签：删除工艺
     * @param technology
     * @return
     */
    @GetMapping("/delete_technology")
    public ResponseVO deleteTechnology(Technology technology){
        service.deleteTechnology(technology);
        return success("删除成功");
    }

}