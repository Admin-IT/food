package edu.nf.food.advice;


import edu.nf.food.user.service.exception.UserException;
import edu.nf.food.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ethan
 * @Classname UserAspect
 * @Description DONE
 * @Date 2020/4/2 12:37
 */
@ControllerAdvice("edu.nf.food.user.web")
public class UserAspect {
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public ResponseVO handlerDataAccessException(UserException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}