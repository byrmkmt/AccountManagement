package com.banking.accountmanagement.exception;

public class MoneyTransferFailedException extends BaseErrorException {

    private MoneyTransferFailedException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static MoneyTransferFailedException of(ErrorCodes code, Object... args) {
        return new MoneyTransferFailedException(code, formatMessage(code, args));
    }

}
