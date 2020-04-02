package edu.nf.food.food.service.exception;

/**
 * @Author ethan
 * @Classname FoodException
 * @Description TODO
 * @Date 2020/4/2 11:44
 */

public class FoodException extends RuntimeException {

    public FoodException(String message) {
        super(message);
    }

    public FoodException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodException(Throwable cause) {
        super(cause);
    }
}
