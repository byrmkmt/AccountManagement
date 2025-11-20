package com.banking.accountmanagement.error.exceptions;

import com.banking.accountmanagement.error.ErrorCodes;

public class AccountNotFoundException extends BaseException {

    private AccountNotFoundException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static AccountNotFoundException of(ErrorCodes code, Object... args) {
        return new AccountNotFoundException(code, formatMessage(code, args));
    }

}
