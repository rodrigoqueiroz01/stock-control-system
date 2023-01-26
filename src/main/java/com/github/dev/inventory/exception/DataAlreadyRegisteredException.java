package com.github.dev.inventory.exception;

import java.io.Serial;

public class DataAlreadyRegisteredException extends RuntimeException {

    @Serial
    public static final long serialVersionUID = 1L;

    public DataAlreadyRegisteredException(String message) {
        super(message);
    }

}
