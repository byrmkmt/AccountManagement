package com.banking.accountmanagement.controller;

import com.banking.accountmanagement.model.dao.AccountTransfer;
import com.banking.accountmanagement.model.dto.AccountTransferDTO;
import com.banking.accountmanagement.model.dto.BankAccountDTO;
import com.banking.accountmanagement.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/profile")
    public ResponseEntity<BankAccountDTO> getAccountInformation(@RequestBody String userId) {
        return new ResponseEntity<>(AccountManagementService.getAccountInformation(userId), HttpStatus.OK);
    }

    /*  Money transfer to an account which either can be from latest account transfers or not. */
    @PostMapping("/transfer/{userId}")
    public ResponseEntity<AccountTransferDTO> makeMoneyTransfer(@PathVariable String  userId, @RequestBody AccountTransferDTO to) {
        return new ResponseEntity<>(AccountManagementService.makeMoneyTransfer(userId,to), HttpStatus.OK);
    }

    /*  To get recently money transfer list */
     @GetMapping("/recentlyTransferList/{userId}")
     public ResponseEntity<List<AccountTransferDTO>> transferList(@PathVariable String  userId) {
         return new ResponseEntity<>(AccountManagementService.transferList(userId), HttpStatus.OK);
     }

    /*  To deactivate or close account  */
    @PatchMapping("/change_status/{id}")
    public ResponseEntity<Object> changeStatusAccount(@PathVariable Long id, @RequestParam("status")  String status) {
        return new ResponseEntity<>(AccountManagementService.changeStatusAccount(id,status), HttpStatus.OK);
    }

}
