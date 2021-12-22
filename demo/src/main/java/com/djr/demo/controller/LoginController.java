package com.djr.demo.controller;

import com.djr.demo.util.JSONResult;
import com.djr.demo.jwt.JwtUtils;
import com.djr.demo.jwt.LoginFailed;
import com.djr.demo.jwt.PassToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PassToken
    @GetMapping(value = "/login")
    public JSONResult login(String userName, String password) throws LoginFailed {

        String jwtToken = JwtUtils.createToken(JwtUtils.USER_ID, userName, password);
        JSONResult jsonResult = JSONResult.ok(jwtToken);

        return jsonResult;
    }

}
