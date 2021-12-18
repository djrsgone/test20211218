package com.bi.djr.demo.service.impl;

import com.bi.djr.demo.pojo.Account;
import com.bi.djr.demo.repository.AccountRepository;
import com.bi.djr.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert(Account account) {
        repository.save(account);
    }

    @Override
    public Account query(int id) {
        Optional<Account> optional = repository.findById(Integer.valueOf(id));
        return optional.isPresent() ? optional.get() : null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean update(Account account) {
        return repository.save(account) != null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void delete(int id) {
        repository.deleteById(Integer.valueOf(id));
    }
}
