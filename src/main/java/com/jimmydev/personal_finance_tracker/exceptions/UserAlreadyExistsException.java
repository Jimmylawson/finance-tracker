package com.jimmydev.personal_finance_tracker.exceptions;



public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){
        super(message);
    }

    public UserAlreadyExistsException(String message,Throwable cause){
        super(message, cause);
    }


}