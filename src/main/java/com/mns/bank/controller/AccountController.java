package com.mns.bank.controller;

import com.mns.bank.bean.AppException;
import com.mns.bank.controller.service.AccountService;
import com.mns.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountController implements IController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Optional<Account> optionalAccount = accountService.findByNumAccount(id);
        if (!optionalAccount.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @PostMapping("/credit/{id}")
    public ResponseEntity<Account> creditAccount(@RequestBody double amount, @PathVariable long id) {
        try {
            Optional<Account> optionalAccount = accountService.findByNumAccount(id);
            if (!optionalAccount.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Account account = optionalAccount.get();
            account.credit(amount);
            accountService.save(account);
            return ResponseEntity.ok().build();
        } catch (AppException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity<Account> withdrawFromAccount(@RequestBody double amount, @PathVariable long id) {
        System.out.println(amount);
        try {
            Optional<Account> optionalAccount = accountService.findByNumAccount(id);
            if (!optionalAccount.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Account account = optionalAccount.get();
            account.withdrawal(amount);
            accountService.save(account);
            return ResponseEntity.ok().build();
        } catch (AppException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
