package com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(String message) {
        super(message);
    }
}
