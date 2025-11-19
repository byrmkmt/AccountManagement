package com.banking.accountmanagement.handler;

import com.banking.accountmanagement.exception.MoneyTransferFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MoneyTransferFailedException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(MoneyTransferFailedException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("İşlem başarısız", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

}