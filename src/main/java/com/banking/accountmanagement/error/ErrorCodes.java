package com.banking.accountmanagement.error;

public enum ErrorCodes {

    ACCOUNT_NOT_FOUND("error.account_not_found"),
    ACCOUNT_ACCESS_FAILED("error.account_access_failed"),
    INVALID_ACCOUNT_NUMBER("error.invalid_account_number"),
    TRANSFER_FAILED("error.transfer_failed");

    private final String key;

    ErrorCodes(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}