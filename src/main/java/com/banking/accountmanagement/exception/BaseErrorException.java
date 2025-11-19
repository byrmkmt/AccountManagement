package com.banking.accountmanagement.exception;

import com.banking.accountmanagement.utility.MessageUtil;

public abstract class BaseErrorException extends RuntimeException {
    private final ErrorCodes code;

    protected BaseErrorException(ErrorCodes code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public String getCodeAsString() {
        return code.name();
    }

    protected static String formatMessage(ErrorCodes code, Object... args) {
        return MessageUtil.get(code.getKey(), args);
    }
}
