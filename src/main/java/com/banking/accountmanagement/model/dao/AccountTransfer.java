package com.banking.accountmanagement.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "account_tranfers")
public class AccountTransfer {
    private Long id;
    private String toAccountNumber;
    private Long quantity;
    private String firstName;
    private String lastName;
    private String message;
    private Date createdDate;

    public AccountTransfer() {}

    public AccountTransfer(Long id, String toAccountNumber, Long quantity, String firstName, String lastName, String message, Date createdDate) {
        this.id = id;
        this.toAccountNumber = toAccountNumber;
        this.quantity = quantity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
        this.createdDate = createdDate;
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

    @Column(name = "account_number", nullable = false, unique = true)
    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    @Column(name = "quantity", nullable = false)
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
