package com.djr.demo.exception;

import com.djr.demo.jwt.NeedToLogin;
import com.djr.demo.jwt.TokenUnavailable;
import com.djr.demo.jwt.UserNotExist;
import com.djr.demo.util.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class JwtGraceExceptionHandler {

    @ExceptionHandler(NeedToLogin.class)
    @ResponseBody
    public JSONResult needToLogin(){
        return JSONResult.errorMsg("login to verify credentials first");
    }

    @ExceptionHandler(UserNotExist.class)
    @ResponseBody
    public JSONResult userNotExist(){
        return JSONResult.errorMsg("user credentials not correct");
    }

    @ExceptionHandler(TokenUnavailable.class)
    @ResponseBody
    public JSONResult tokenUnavailable(){
        return JSONResult.errorMsg("token is unvailable and login again");
    }
}

