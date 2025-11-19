package com.banking.accountmanagement.model.dto;

import com.banking.accountmanagement.model.AccountStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record BankAccountDTO(
        String userId,
        String accountNumber,
        String firstName,
        String lastName,
        Long balance,
        AccountStatus status,
        List<AccountTransferDTO> latestTransfers,
        Date lastLogin
) implements Serializable {
}