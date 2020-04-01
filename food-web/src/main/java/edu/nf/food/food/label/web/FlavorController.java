package edu.nf.food.food.label.web;

import edu.nf.food.food.label.entity.Flavor;
import edu.nf.food.food.label.service.FlavorService;
import edu.nf.food.food.util.BaseController;
import edu.nf.food.food.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author ljf
 * @date 2020/3/20
 * 口味
 */
@RestController
public class FlavorController extends BaseController {
    private FlavorService service;

    /**
     * 标签：口味 查询全部
     * @return
     */
    @GetMapping("/list_flavor")
    public ResponseVO listFlavor(){
        List<Flavor> list = service.listFlavor();
        return success(list);
    }

    /**
     * 标签：口味 添加
     * @param flavor
     * @return
     */
    @PostMapping("/add_flavor")
    public ResponseVO addFlavor(Flavor flavor){
        service.addFlavor(flavor);
        return success("添加成功");
    }

    /**
     * 标签：口味 删除
     * @param flavor
     * @return
     */
    @GetMapping("/del_flavor")
    public ResponseVO delFlavor(Flavor flavor){
        service.delFlavor(flavor);
        return success("删除成功");
    }

}