package com.banking.accountmanagement.repository;

import com.banking.accountmanagement.model.dao.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountManagementRepository extends JpaRepository<BankAccount, Long> {

    public BankAccount findByUserId(String userId);

}
