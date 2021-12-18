package com.djr.demo.service;

import com.djr.demo.pojo.Account;

public interface AccountService {

    public void insert(Account account);
    public Account query(int id);
    public boolean update(Account account);
    public void delete(int id);

}
