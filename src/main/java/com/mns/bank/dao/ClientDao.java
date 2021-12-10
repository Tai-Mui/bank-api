package com.mns.bank.dao;

import com.mns.bank.model.Client;

import java.util.Optional;

public interface ClientDao extends IDao<Client> {

	Optional<Client> findByNumClient(Long id);

	Optional<Client> findByEmailAndPassword(String email, String password);
}
