package com.mns.bank.dao;

import java.util.List;
import java.util.Optional;

import com.mns.bank.model.Client;

import javax.persistence.EntityManager;

public class ClientDao implements IDao<Client> {

	private EntityManager entityManager;

	@Override
	public Optional<Client> get(long id) {
		return Optional.ofNullable(entityManager.find(Client.class, id));
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Client t) {
		// TODO Auto-generated method stub
		return 0l;
	}

	@Override
	public void update(Client t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client t) {
		// TODO Auto-generated method stub
		
	}

	public Client getByEmail(String email) {

	}

}
