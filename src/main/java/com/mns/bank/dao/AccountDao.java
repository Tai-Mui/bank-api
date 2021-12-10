package com.mns.bank.dao;

import com.mns.bank.model.Account;

import java.util.Optional;

public interface AccountDao extends IDao<Account> {

    Optional<Account> findByNumAccount(Long id);
}
