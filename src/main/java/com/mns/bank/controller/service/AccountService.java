package com.mns.bank.controller.service;

import com.mns.bank.dao.AccountDao;
import com.mns.bank.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Optional<Account> findByNumAccount(Long id) {
        return accountDao.findByNumAccount(id);
    }

    public void save(Account account) {
        accountDao.save(account);
    }
}
