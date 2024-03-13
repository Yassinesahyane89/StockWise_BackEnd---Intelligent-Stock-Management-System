package com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
