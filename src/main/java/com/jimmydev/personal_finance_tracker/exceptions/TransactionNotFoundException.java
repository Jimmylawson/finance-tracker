package com.jimmydev.personal_finance_tracker.exceptions;



public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

}
