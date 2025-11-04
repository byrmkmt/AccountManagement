package com.banking.accountmanagement.model;

public enum AccountStatus {
    ACTIVE,
    DEACTIVATED,
    CLOSED;

    public static AccountStatus fromString(String status) {
        for (AccountStatus accountStatus : AccountStatus.values()) {
            if (accountStatus.name().equalsIgnoreCase(status)) {
                return accountStatus;
            }
        }
        return null;
    }

}
