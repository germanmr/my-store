package com.mycompany.mystore.exceptions;

public class NoOrderFoundException extends RuntimeException {

    public NoOrderFoundException() {
    }

    public NoOrderFoundException(String message) {
        super(message);
    }

}
