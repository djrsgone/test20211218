package com.djr.demo.controller;

import com.alibaba.fastjson.JSON;
import com.djr.demo.util.JSONResult;
import com.djr.demo.pojo.Account;
import com.djr.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public JSONResult query(){
        JSONResult jsonResult = accountService.queryAll();
        return jsonResult;
    }

    @GetMapping("/{id}")
    public JSONResult query(@PathVariable int id){
        JSONResult jsonResult = accountService.query(Integer.valueOf(id));
        return jsonResult;
    }

    @PostMapping
    public JSONResult insert(@RequestBody Account account){
        JSONResult jsonResult = this.accountService.insert(account);
        return jsonResult;
    }

    @PutMapping
    public JSONResult update(@RequestBody  Account account){
        JSONResult jsonResult = this.accountService.update(account);
        return jsonResult;
    }

    @DeleteMapping("/{id}")
    public JSONResult delete(@PathVariable  int id){
        JSONResult jsonResult = accountService.delete(Integer.valueOf(id));
        return jsonResult;
    }
}
