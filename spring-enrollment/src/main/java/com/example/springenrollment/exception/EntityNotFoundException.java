package com.example.springenrollment.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String error) {
        super(error);
    }
}
