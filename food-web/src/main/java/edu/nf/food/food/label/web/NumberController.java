package edu.nf.food.food.label.web;

import edu.nf.food.food.label.entity.Number;
import edu.nf.food.food.label.service.NumberService;
import edu.nf.food.food.util.BaseController;
import edu.nf.food.food.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 人数
 */
@RestController
public class NumberController extends BaseController {

    private NumberService service;

    /**
     * 标签：人数查询
     * @return
     */
    @GetMapping("/list_number")
    public ResponseVO listNumber(){
        List<Number> list = service.listNumber();
        return success(list);
    }

    /**
     * 标签：人数 添加
     * @param number
     * @return
     */
    @PostMapping("/add_number")
    public ResponseVO addNumber(Number number){
        service.addNumber(number);
        return success("添加成功");
    }

    /**
     * 标签： 人数 删除
     * @param number
     * @return
     */
    @GetMapping("/del_number")
    public ResponseVO delNumber(Number number){
        service.delNumber(number);
        return success("删除成功");
    }
}