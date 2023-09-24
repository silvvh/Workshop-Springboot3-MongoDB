package com.silvvh.workshopmongo.service;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private final static long serialVersionUID = 1L;
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
