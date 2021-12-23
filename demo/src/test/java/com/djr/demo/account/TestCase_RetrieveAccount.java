package com.djr.demo.account;

import com.djr.demo.account.BaseTest;
import com.djr.demo.pojo.Account;
import com.djr.demo.util.JSONResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestCase_RetrieveAccount extends BaseTest {

    @Test
    public void test0_queryAll(){
        JSONResult jsonResult = accountController.query();
        Assert.assertTrue(jsonResult.getOk());

        List<Account> accounts = (List<Account>) jsonResult.getData();
        Assert.assertNotNull(accounts);
        Assert.assertTrue(accounts.size() >= 1);
    }

    @Test
    public void test1_1_query_negative(){
        JSONResult jsonResult = accountController.query(-1);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test1_2_query_zero(){
        JSONResult jsonResult = accountController.query(0);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test1_3_query_positive(){
        JSONResult jsonResult = accountController.query(1);
        Assert.assertTrue(jsonResult.getOk());
    }

}
