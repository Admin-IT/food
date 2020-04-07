package edu.nf.food.util;

import edu.nf.food.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ljf
 * @date 2020/4/4
 */
public class testController {
    @GetMapping("/test")
    public ResponseVO test() {
        return null;
    }
}