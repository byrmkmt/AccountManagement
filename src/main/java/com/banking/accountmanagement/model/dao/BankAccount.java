package com.banking.accountmanagement.model.dao;

import com.banking.accountmanagement.model.AccountStatus;
import com.banking.accountmanagement.model.dao.AccountTransfer;

import java.util.Date;
import java.util.List;

public class BankAccount {
    private Long id;
    private String userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Long balance;
    private AccountStatus status;
    private List<AccountTransfer> latestTransfers;
    private Date lastLoginDate;
    private Date createdDate;
    private Date lastUpdatedDate;

    public BankAccount() {}

    public BankAccount(Long id, String userId, String accountNumber, String firstName, String lastName, Long balance, AccountStatus status, List<AccountTransfer> latestTransfers, Date lastLoginDate, Date createdDate, Date lastUpdatedDate) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.status = status;
        this.latestTransfers = latestTransfers;
        this.lastLoginDate = lastLoginDate;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public List<AccountTransfer> getLatestTransfers() {
        return latestTransfers;
    }

    public void setLatestTransfers(List<AccountTransfer> latestTransfers) {
        this.latestTransfers = latestTransfers;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
