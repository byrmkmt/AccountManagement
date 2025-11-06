package com.banking.accountmanagement.model.dto;
import com.banking.accountmanagement.model.AccountStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BankAccountDTO implements Serializable {
    private String userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Long balance;
    private AccountStatus status;
    private List<AccountTransferDTO> latestTransfers;
    private Date lastLogin;

    public BankAccountDTO() {

    }

    public BankAccountDTO(String userId, String accountNumber, String firstName, String lastName, Long balance, AccountStatus status, List<AccountTransferDTO> latestTransfers, Date lastLoginDate) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.status = status;
        this.latestTransfers = latestTransfers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<AccountTransferDTO> getLatestTransfers() {
        return latestTransfers;
    }

    public void setLatestTransfers(List<AccountTransferDTO> latestTransfers) {
        this.latestTransfers = latestTransfers;
    }

    public Date getLastLoginDate() {
        return lastLogin;
    }

    public void setLastLoginDate(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
