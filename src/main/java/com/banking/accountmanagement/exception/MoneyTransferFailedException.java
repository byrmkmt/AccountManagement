package com.banking.accountmanagement.exception;

public class MoneyTransferFailedException extends RuntimeException {

    public MoneyTransferFailedException(String message) {
        super(message);
    }
    
}
