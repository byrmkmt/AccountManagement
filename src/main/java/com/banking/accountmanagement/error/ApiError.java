package com.banking.accountmanagement.error;

import java.time.LocalDateTime;

public record ApiError(
        String code,
        String message,
        LocalDateTime timestamp,
        String path
) {
    public ApiError(String code, String message, String path) {
        this(code, message, LocalDateTime.now(), path);
    }
}
