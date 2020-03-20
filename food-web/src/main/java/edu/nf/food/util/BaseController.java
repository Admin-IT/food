package edu.nf.food.util;

import edu.nf.food.vo.ResponseVO;
import org.springframework.http.HttpStatus;

/**
 * @author ljf
 * @date 2020/3/20
 */
public class BaseController {
    public <T>ResponseVO<T> success(T data){
          ResponseVO<T> vo = new ResponseVO<>();
          vo.setCode(HttpStatus.OK.value());
          vo.setData(data);
          return vo;
    }

    public ResponseVO success(String message){
          ResponseVO vo = new ResponseVO();
          vo.setCode(HttpStatus.OK.value());
          vo.setMessage(message);
          return vo;
    }

    public ResponseVO fail(Integer code){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        return vo;
    }

    public ResponseVO fail(Integer code,String message){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}