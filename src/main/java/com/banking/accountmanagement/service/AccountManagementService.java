package com.banking.accountmanagement.service;

import com.banking.accountmanagement.event.model.AccountCreatedEvent;
import com.banking.accountmanagement.model.AccountStatus;
import com.banking.accountmanagement.model.dao.BankAccount;
import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.repository.AccountManagementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class AccountManagementService {

    private final AccountManagementRepository accountManagementRepository;

    public AccountManagementService(AccountManagementRepository accountManagementRepository) {
        this.accountManagementRepository = accountManagementRepository;
    }

    public void saveAccount(AccountCreatedEvent message){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUserId(message.getUserId());
        bankAccount.setAccountNumber(message.getAccountNumber());
        bankAccount.setFirstName(message.getFirstName());
        bankAccount.setLastName(message.getLastName());
        bankAccount.setBalance(1000L);
        bankAccount.setStatus(AccountStatus.ACTIVE);
        bankAccount.setCreatedDate(message.getCreatedDate());
        bankAccount.setLastUpdatedDate(message.getLastUpdatedDate());
        accountManagementRepository.save(bankAccount);
    }

    public BankAccountDTO getAccountInformation(String userId) {
        BankAccount account = accountManagementRepository.findByUserId(userId);
        if(account != null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(account, BankAccountDTO.class);
        }
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
