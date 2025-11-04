package com.banking.accountmanagement.service;

import com.banking.accountmanagement.model.AccountStatus;
import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.repository.AccountManagementRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class AccountManagementService {

    private final AccountManagementRepository accountManagementRepository;

    public AccountManagementService(AccountManagementRepository accountManagementRepository) {
        this.accountManagementRepository = accountManagementRepository;
    }

    public BankAccountDTO getAccountInformation(Long id) {
        accountManagementRepository.findById(id);
        return null;
    }

    public AccountTransferDTO makeMoneyTransfer(Long id, AccountTransferDTO to) {
        return null;
    }

    /*  to deactivate or close account  */
    public AccountStatus changeStatusAccount(@PathVariable Long id, @RequestParam("status")  String status) {
        return null;
    }

}
