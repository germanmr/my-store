package com.mycompany.mystore.exceptions;

public class NoOrderFoundException extends RuntimeException {

    private Long orderIr;

    public NoOrderFoundException() {
    }

    public NoOrderFoundException(String message) {
        super(message);
    }

    public NoOrderFoundException(Long orderId) {
        this.orderIr = orderId;
    }

    public Long getOrderIr() {
        return orderIr;
    }
}
