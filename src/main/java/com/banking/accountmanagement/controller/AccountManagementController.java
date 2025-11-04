package com.banking.accountmanagement.controller;

import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountManagementController {

    private final AccountManagementService AccountManagementService;

    @Autowired
    public AccountManagementController(AccountManagementService AccountManagementService) {
        this.AccountManagementService = AccountManagementService;
    }

    /*  Account information and latest account transfers will be shown   */
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDTO> getAccountInformation(@PathVariable Long id) {
        return new ResponseEntity<>(AccountManagementService.getAccountInformation(id), HttpStatus.OK);
    }

    /*  Money transfer to an account which either can be from latest account transfers or not. */
    @PostMapping("/transfer/{id}")
    public ResponseEntity<AccountTransferDTO> makeMoneyTransfer(@PathVariable Long id, AccountTransferDTO to) {
        return new ResponseEntity<>(AccountManagementService.makeMoneyTransfer(id,to), HttpStatus.OK);
    }

    /*  to deactivate or close account  */
    @PatchMapping("/change_status/{id}")
    public ResponseEntity<Object> changeStatusAccount(@PathVariable Long id, @RequestParam("status")  String status) {
        return new ResponseEntity<>(AccountManagementService.changeStatusAccount(id,status), HttpStatus.OK);
    }

}
