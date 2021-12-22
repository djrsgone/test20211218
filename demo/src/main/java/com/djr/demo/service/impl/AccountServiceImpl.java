package com.djr.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.djr.demo.pojo.Account;
import com.djr.demo.repository.AccountMapper;
import com.djr.demo.service.AccountService;
import com.djr.demo.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    private JSONResult buildJsonError(String operation, Exception e){
        JSONResult jsonResult = JSONResult.errorMsg(operation + "[ErrMsg=" + e.getMessage() + "]");
        return jsonResult;
    }

    @Override
    public JSONResult insert(Account account) {
        JSONResult jsonResult = null;
        if(account == null)
        {
            jsonResult = JSONResult.errorMsg("account is null");
            return jsonResult;
        }

        try {
            mapper.add(account);
            jsonResult = JSONResult.ok(account);
        }catch (Exception e){
            jsonResult = buildJsonError("fail to insert account", e);
            e.printStackTrace();
        }

        return jsonResult;
    }

    @Override
    public JSONResult query(int id) {
        JSONResult jsonResult = null;
        try
        {
            Account account = mapper.getById(id);
            jsonResult = account == null ?
                    JSONResult.errorMsg("account not exist") : JSONResult.ok(account);
        }catch (Exception e){
            jsonResult = buildJsonError("fail to query account", e);
            e.printStackTrace();
        }
        return jsonResult;
    }

    @Override
    public JSONResult queryAll() {
        JSONResult jsonResult = null;
        try
        {
            List<Account> accounts = mapper.getAll();
            jsonResult = accounts == null ?
                    JSONResult.errorMsg("account not exist") : JSONResult.ok(accounts);
        }catch (Exception e){
            jsonResult = buildJsonError("fail to query account", e);
            e.printStackTrace();
        }
        return jsonResult;
    }

    @Override
    public JSONResult update(Account account) {
        JSONResult jsonResult = null;
        if(account == null)
        {
            jsonResult = JSONResult.errorMsg("account is null");
            return jsonResult;
        }

        try
        {
            mapper.update(account);
            jsonResult = JSONResult.ok(account);
        }catch (Exception e){
            jsonResult = buildJsonError("fail to update account", e);
            e.printStackTrace();
        }
        return jsonResult;
    }

    @Override
    public JSONResult delete(int id) {
        JSONResult jsonResult = JSONResult.ok();
        try
        {
            mapper.deleteById(id);
        }catch (Exception e){
            jsonResult = buildJsonError("fail to delete account", e);
            e.printStackTrace();
        }
        return jsonResult;
    }

}
