package edu.nf.food.label.web;

import edu.nf.food.label.entity.Difficulty;
import edu.nf.food.label.service.DifficultyService;
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
 * 难度
 */
@RestController
public class DifficultyController extends BaseController {
    @Autowired
    private DifficultyService service;

    /**
     * 标签：难度表 查询全部
     * @return
     */
    @GetMapping("/list_difficulty")
    public ResponseVO listDifficulty(){
        List<Difficulty> list = service.listDifficulty();
        return success(list);
    }


    /**
     * 标签：难度 添加
     * @param difficulty
     * @return
     */
    @PostMapping("/add_difficulty")
    public ResponseVO addDifficulty(Difficulty difficulty){
        service.addDiffculty(difficulty);
        return success("添加成功");
    }

    /**
     * 标签：难度 删除
     * @param difficulty
     * @return
     */
    @PostMapping("/add_difficulty")
    public ResponseVO delDifficulty(Difficulty difficulty){
        service.delDiffculty(difficulty);
        return success("删除成功");
    }
}