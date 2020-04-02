package edu.nf.food.advice;

import edu.nf.food.label.service.exception.LabelException;
import edu.nf.food.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ljf
 * @date 2020/3/20
 */
@ControllerAdvice("edu.nf.food.label.web")
public class LabelAspect {
    @ExceptionHandler(LabelException.class)
    @ResponseBody
    public ResponseVO handlerDataAccessException(LabelException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}