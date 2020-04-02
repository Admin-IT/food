package edu.nf.food.user.service.exception;

/**
 * @Author ethan
 * @Classname UserException
 * @Description TODO
 * @Date 2020/4/2 11:41
 */

public class UserException extends RuntimeException  {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
