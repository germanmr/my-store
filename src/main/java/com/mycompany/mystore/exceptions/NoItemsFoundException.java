package com.mycompany.mystore.exceptions;

public class NoItemsFoundException extends RuntimeException {

    public NoItemsFoundException() {
    }

    public NoItemsFoundException(String message) {
        super(message);
    }

}
