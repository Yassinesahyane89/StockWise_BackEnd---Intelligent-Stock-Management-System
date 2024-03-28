package com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
