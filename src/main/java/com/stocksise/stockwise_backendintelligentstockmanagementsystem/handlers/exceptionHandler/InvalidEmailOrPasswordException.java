package com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler;

public class InvalidEmailOrPasswordException extends RuntimeException{
    public InvalidEmailOrPasswordException(String message){
        super(message);
    }
}
