package com.mycompany.mystore.exceptions;

public class NoStockFoundException extends RuntimeException {

    public NoStockFoundException() {
    }

    public NoStockFoundException(String message) {
        super(message);
    }

}