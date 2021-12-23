package com.djr.demo.account;

import com.djr.demo.controller.AccountController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest{

    @Resource
    protected AccountController accountController;

    protected static AtomicInteger idGenerator = new AtomicInteger(10000);

}
