package com.mycompany.mystore.exceptions;

public class NoClientsException extends RuntimeException {

    public NoClientsException() {
    }

    public NoClientsException(String message) {
        super(message);
    }

}
