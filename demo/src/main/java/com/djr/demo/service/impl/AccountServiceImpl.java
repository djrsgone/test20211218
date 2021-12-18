package com.djr.demo.service.impl;

import com.djr.demo.pojo.Account;
import com.djr.demo.repository.AccountMapper;
import com.djr.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public void insert(Account account) {
        mapper.add(account);
    }

    @Override
    public Account query(int id) {
        return mapper.getById(id);
    }

    @Override
    public boolean update(Account account) {
        mapper.update(account);
        return true;
    }

    @Override
    public void delete(int id) {
        mapper.deleteById(id);
    }

    /*
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
     */
}
