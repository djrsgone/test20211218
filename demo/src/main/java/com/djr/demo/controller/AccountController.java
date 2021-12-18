package com.djr.demo.controller;

import com.djr.demo.JSONResult;
import com.djr.demo.jwt.JwtUtils;
import com.djr.demo.jwt.LoginFailed;
import com.djr.demo.jwt.PassToken;
import com.djr.demo.pojo.Account;
import com.djr.demo.pojo.bo.AccountBO;
import com.djr.demo.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    private static AtomicInteger idGenerator = new AtomicInteger(1);

    @PassToken
    @GetMapping(value = "/login")
    public JSONResult login(String userName, String password) throws LoginFailed {

        //给分配一个token 然后返回
        String jwtToken = JwtUtils.createToken(JwtUtils.USER_ID, userName, password);
        JSONResult jsonResult = JSONResult.ok();
        jsonResult.setMsg(jwtToken);

        return jsonResult;

    }

    @GetMapping("/query/{id}")
    public JSONResult query(@PathVariable int id){
        if(id <= 0){
            JSONResult jsonResult = JSONResult.errorMsg("id is <=0 ");
            return jsonResult;
        }

        Account account = accountService.query(id);
        JSONResult jsonResult = account == null ? JSONResult.errorMsg("fail to query account") : JSONResult.ok(account);
        return jsonResult;
    }

    @PostMapping("/insert")
    public JSONResult insert(@Valid @RequestBody AccountBO accountBO,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> map = getErrors(bindingResult);
            JSONResult jsonResult = JSONResult.errorMap(map);
            return jsonResult;
        }

        Account account = new Account();
        BeanUtils.copyProperties(accountBO, account);
        account.setId(idGenerator.incrementAndGet());

        this.accountService.insert(account);
        JSONResult jsonResult = JSONResult.ok(account);
        return jsonResult;
    }

    @PutMapping("/update")
    public JSONResult update(@Valid @RequestBody AccountBO accountBO,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> map = getErrors(bindingResult);
            JSONResult jsonResult = JSONResult.errorMap(map);
            return jsonResult;
        }

        Account account = new Account();
        BeanUtils.copyProperties(accountBO, account);

        boolean success = this.accountService.update(account);
        JSONResult jsonResult = success ? JSONResult.ok(account): JSONResult.errorMsg("fail to update account");
        return jsonResult;
    }

    @DeleteMapping("/delete/{id}")
    public JSONResult delete(@PathVariable int id){
        if(id <= 0){
            JSONResult jsonResult = JSONResult.errorMsg("id is <=0 ");
            return jsonResult;
        }

        accountService.delete(id);
        return JSONResult.ok();
    }

    private Map<String, String> getErrors(BindingResult result){
        Map<String, String> map = new LinkedHashMap<>();

        List<FieldError> errorList = result.getFieldErrors();
        for(FieldError error : errorList){
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }

        return map;
    }

}
