package com.github.dev.inventory.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {

    @Serial
    public static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }

}
