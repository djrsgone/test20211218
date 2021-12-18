package com.example.firstappdemo.controller;

import com.example.firstappdemo.MyConfig;
import com.example.firstappdemo.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {


    @Autowired
    private MyConfig myConfig;

    @Autowired
    private MyAsyncTask myAsyncTask;

    @GetMapping("getMyConfig")
    public Object getMyConfig(){
        myAsyncTask.publishMsg();
        log.info("Controller主体内容执行完毕");
        return myConfig;
    }
}
