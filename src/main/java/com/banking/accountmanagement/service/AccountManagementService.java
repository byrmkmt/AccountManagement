package com.banking.accountmanagement.service;

import com.banking.accountmanagement.event.model.AccountCreatedEvent;
import com.banking.accountmanagement.exception.MoneyTransferFailedException;
import com.banking.accountmanagement.model.AccountStatus;
import com.banking.accountmanagement.model.dao.AccountTransfer;
import com.banking.accountmanagement.model.dao.BankAccount;
import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.repository.AccountManagementRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public AccountTransferDTO makeMoneyTransfer(String userId, AccountTransferDTO to) {
        BankAccount source = accountManagementRepository.findByUserId(userId);
        if(source == null){
            throw new RuntimeException("Hesabınızda erişim sorunu oluştu.");
        }
        BankAccount target = accountManagementRepository.findByAccountNumber(to.getToAccountNumber());
        if(target == null){
            throw new MoneyTransferFailedException("Müşteri numarası geçersiz!");
        }
        if(source.getBalance() >= to.getQuantity()){
            ModelMapper modelMapper = new ModelMapper();
            AccountTransfer transfer = modelMapper.map(to, AccountTransfer.class);
            transfer.setFromAccount(source);

            source.setBalance(source.getBalance() - to.getQuantity());
            target.setBalance(target.getBalance() + to.getQuantity());

            source.getLatestTransfers().add(transfer);
        } else{
            throw new MoneyTransferFailedException("Yetersiz bakiye limiti!");
        }
        return to;
    }

    public List<AccountTransferDTO> transferList(String userId) {
        BankAccount account = accountManagementRepository.findByUserId(userId);
        if(account == null){
            return null;
        }
        return account.getLatestTransfers()
                .stream()
                .map(transfer -> {
                    AccountTransferDTO dto = new AccountTransferDTO();
                    dto.setId(transfer.getId());
                    dto.setToAccountNumber(transfer.getAccountNumber());
                    dto.setFirstName(transfer.getFirstName());
                    dto.setLastName(transfer.getLastName());
                    dto.setQuantity(transfer.getQuantity());
                    dto.setMessage(transfer.getMessage());
                    dto.setCreatedDate(transfer.getCreatedDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    /*  to deactivate or close account  */
    public AccountStatus changeStatusAccount(@PathVariable Long id, @RequestParam("status")  String status) {
        return null;
    }

}
