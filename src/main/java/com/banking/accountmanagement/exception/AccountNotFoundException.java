package com.banking.accountmanagement.exception;

public class AccountNotFoundException extends BaseErrorException {

    private AccountNotFoundException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static AccountNotFoundException of(ErrorCodes code, Object... args) {
        return new AccountNotFoundException(code, formatMessage(code, args));
    }

}
