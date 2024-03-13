package com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler;

public class OperationException extends RuntimeException{
    public OperationException(String message){
        super(message);
    }
}
