package com.mns.bank.controller.service;

import com.mns.bank.dao.ClientDao;
import com.mns.bank.model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Optional<Client> findByNumClient(Long id) {
        return clientDao.findByNumClient(id);
    }

    public Optional<Client> findByEmailAndPassword(String email, String password) {
        return clientDao.findByEmailAndPassword(email, password);
    }
}
