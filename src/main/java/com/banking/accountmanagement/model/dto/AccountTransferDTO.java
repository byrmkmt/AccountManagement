package com.banking.accountmanagement.model.dto;

import java.util.Date;

public class AccountTransferDTO {
    private Long id;
    private String toAccountNumber;
    private Long quantity;
    private String firstName;
    private String lastName;
    private String message;
    private Date createdDate;

    public AccountTransferDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountTransferDTO(String toAccountNumber, Long quantity, String firstName, String lastName, String message, Date createdDate) {
        this.toAccountNumber = toAccountNumber;
        this.quantity = quantity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
        this.createdDate = createdDate;
    }



    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
