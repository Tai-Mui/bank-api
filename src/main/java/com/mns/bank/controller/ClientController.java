package com.mns.bank.controller;

import com.mns.bank.controller.service.ClientService;
import com.mns.bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController implements IController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        Optional<Client> optionalClient = clientService.findByNumClient(id);
        if (!optionalClient.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalClient.get());
    }

    @PostMapping("/login")
    public ResponseEntity<Client> findByEmailAndPassword(@RequestBody Client client) {
        Optional<Client> optionalClient = clientService.findByEmailAndPassword(client.getEmail(), client.getPassword());
        if (!optionalClient.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalClient.get());
    }

}
