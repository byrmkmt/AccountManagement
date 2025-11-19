package com.banking.accountmanagement.service;

import com.banking.accountmanagement.event.model.AccountCreatedEvent;
import com.banking.accountmanagement.exception.AccountNotFoundException;
import com.banking.accountmanagement.exception.MoneyTransferFailedException;
import com.banking.accountmanagement.model.AccountStatus;
import com.banking.accountmanagement.model.dao.AccountTransfer;
import com.banking.accountmanagement.model.dao.BankAccount;
import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.repository.AccountManagementRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountManagementService {

    private final ModelMapper modelMapper;

    private final AccountManagementRepository accountManagementRepository;

    public AccountManagementService(ModelMapper modelMapper, AccountManagementRepository accountManagementRepository) {
        this.modelMapper = modelMapper;
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

    @Cacheable(value = "accountProfile", key = "#userId")
    public BankAccountDTO getAccountInformation(String userId) {
        BankAccount account = accountManagementRepository.findByUserId(userId);
        if(account == null){
            throw new AccountNotFoundException("Hesap bulunamadı: " + userId);
        }
        return modelMapper.map(account, BankAccountDTO.class);
    }

    @Transactional
    @CacheEvict(value = {"accountProfile", "transferList"}, key = "#userId")
    public AccountTransferDTO makeMoneyTransfer(String userId, AccountTransferDTO to) {
        BankAccount source = accountManagementRepository.findByUserId(userId);
        if(source == null){
            throw new MoneyTransferFailedException("Hesabınızda erişim sorunu oluştu.");
        }
        BankAccount target = accountManagementRepository.findByAccountNumber(to.getToAccountNumber());
        if(target == null){
            throw new MoneyTransferFailedException("Müşteri numarası geçersiz!");
        }
        if(source.getBalance() >= to.getQuantity()){
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

    @Cacheable(value = "transferList", key = "#userId")
    public List<AccountTransferDTO> transferList(String userId) {
        BankAccount account = accountManagementRepository.findByUserId(userId);
        if(account == null){
            return Collections.emptyList();
        }
        return account.getLatestTransfers()
                .stream()
                .map(transfer -> modelMapper.map(transfer, AccountTransferDTO.class))
                .collect(Collectors.toList());
    }

    /*  to deactivate or close account  */
    public AccountStatus changeStatusAccount(@PathVariable Long id, @RequestParam("status")  String status) {
        return null;
    }

}
