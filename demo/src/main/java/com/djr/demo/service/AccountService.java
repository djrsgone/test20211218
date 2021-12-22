package com.djr.demo.service;

import com.alibaba.fastjson.JSON;
import com.djr.demo.pojo.Account;
import com.djr.demo.util.JSONResult;

public interface AccountService {

    public JSONResult insert(Account account);
    public JSONResult query(int id);
    public JSONResult queryAll();
    public JSONResult update(Account account);
    public JSONResult delete(int id);

}
