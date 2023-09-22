package com.vhbrito.workshop.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    private final static long serialVersionUID = 1L;

    public DatabaseException(String message) {
        super(message);
    }
}
