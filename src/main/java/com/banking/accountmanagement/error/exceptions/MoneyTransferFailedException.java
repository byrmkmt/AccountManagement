package com.banking.accountmanagement.error.exceptions;

import com.banking.accountmanagement.error.ErrorCodes;

public class MoneyTransferFailedException extends BaseException {

    private MoneyTransferFailedException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static MoneyTransferFailedException of(ErrorCodes code, Object... args) {
        return new MoneyTransferFailedException(code, formatMessage(code, args));
    }

}
