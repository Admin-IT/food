package edu.nf.food.label.service.exception;

/**
 * @author ljf
 * @date 2020/3/20
 * 自定义异常
 */
public class LabelException extends RuntimeException {
    public LabelException(String message) {
        super(message);
    }

    public LabelException(String message, Throwable cause) {
        super(message, cause);
    }

    public LabelException(Throwable cause) {
        super(cause);
    }
}