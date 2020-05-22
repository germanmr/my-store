package com.mycompany.mystore.exceptions;

public class NoClientFoundException extends RuntimeException {

    public NoClientFoundException() {
    }

    public NoClientFoundException(String message) {
        super(message);
    }

}
