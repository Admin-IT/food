package edu.nf.food.food.label.web;

import edu.nf.food.food.label.service.CookTimeService;
import edu.nf.food.food.label.entity.CookTime;
import edu.nf.food.food.util.BaseController;
import edu.nf.food.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 烹饪时间
 */
@RestController
public class CookTimeController extends BaseController {
    @Autowired
    private CookTimeService service;

    @GetMapping("/list_cooktime")
    public ResponseVO listCookTime(){
        List<CookTime> list = service.listCookTime();
        return success(list);
    }

    @PostMapping("/add_cooktime")
    public ResponseVO addCookTime(CookTime cooktime){
        service.addCookTime(cooktime);
        return success("添加失败");
    }

    @GetMapping("/del_cooktime")
    public ResponseVO delCookTime(CookTime cooktime){
        service.delCookTime(cooktime);
        return success("删除失败");
    }
}