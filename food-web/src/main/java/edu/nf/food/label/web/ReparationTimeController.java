package edu.nf.food.label.web;

import edu.nf.food.label.entity.ReparationTime;
import edu.nf.food.label.service.ReparationTimeService;
import edu.nf.food.util.BaseController;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljf
 * @date 2020/3/20
 * 准备时间
 */
@RestController
public class ReparationTimeController extends BaseController {
    @Autowired
    private ReparationTimeService service;

    @GetMapping("/list_reparationtime")
    public ResponseVO listReparationTime(){
        List<ReparationTime> list = service.listReparationTime();
        return success(list);
    }

    @GetMapping("/add_reparationtime")
    public ResponseVO addReparationTime(ReparationTime reparationTime){
        service.addReparationTime(reparationTime);
        return success("添加成功");
    }

    @GetMapping("/del_reparationtime")
    public ResponseVO delReparationTime(ReparationTime reparationTime){
        service.delReparationTime(reparationTime);
        return success("删除成功");
    }
}