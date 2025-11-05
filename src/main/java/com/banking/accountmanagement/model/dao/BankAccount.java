package com.banking.accountmanagement.model.dao;

import com.banking.accountmanagement.model.AccountStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**

 */

@Entity
@Table(name = "bank_accounts")
public class BankAccount implements Serializable {
    private Long id;
    private String userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Long balance;
    private AccountStatus status;
    private List<AccountTransfer> latestTransfers;
    private Date lastLogin;
    private Date createdDate;
    private Date lastUpdatedDate;

    public BankAccount() {}

    public BankAccount(Long id, String userId, String accountNumber, String firstName, String lastName, Long balance, AccountStatus status, List<AccountTransfer> latestTransfers, Date lastLogin, Date createdDate, Date lastUpdatedDate) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.status = status;
        this.latestTransfers = latestTransfers;
        this.lastLogin = lastLogin;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="user_id", nullable = false, unique = true)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name="account_number", nullable = false, unique = true)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="surname", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="balance", nullable = false)
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Column(name="status", nullable = false)
    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_latest_transfers"))
    public List<AccountTransfer> getLatestTransfers() {
        return latestTransfers;
    }

    public void setLatestTransfers(List<AccountTransfer> latestTransfers) {
        this.latestTransfers = latestTransfers;
    }

    @Column(name = "last_login")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(name = "created_date", nullable = false, updatable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "last_update")
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
