package com.mycompany.mystore.exceptions;

public class NoItemFoundException extends RuntimeException {

    public NoItemFoundException() {
    }

    public NoItemFoundException(String message) {
        super(message);
    }

}
