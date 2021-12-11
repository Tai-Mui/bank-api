package com.mns.bank.controller;

import com.mns.bank.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/transfert")
public class FakeExternalTransfertController {

    @PostMapping("/{id}")
    public ResponseEntity<Account> transfertToExternalAccount(@RequestBody double amount, @PathVariable long id) {
        if (amount < 0) {
            return ResponseEntity.badRequest().build();
        }
        if (id > 1000) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}