package com.mycompany.mystore.exceptions;

public class NoClientsFoundException extends RuntimeException {

    public NoClientsFoundException() {
    }

    public NoClientsFoundException(String message) {
        super(message);
    }

}
