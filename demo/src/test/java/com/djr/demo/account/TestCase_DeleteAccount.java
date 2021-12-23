package com.djr.demo.account;

import com.djr.demo.account.BaseTest;
import com.djr.demo.pojo.Account;
import com.djr.demo.util.JSONResult;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestCase_DeleteAccount extends BaseTest {

    @Test
    public void test3_1_delete_existing(){
        final int id = idGenerator.incrementAndGet();
        Account account = new Account();
        account.setId(id);
        account.setName("12");
        account.setPassword("12");
        accountController.insert(account);
        Assert.assertNotNull(accountController.query(id));

        accountController.delete(id);
        JSONResult jsonResult = accountController.query(id);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test3_2_delete_unexisting(){
        final int id = -1;
        accountController.delete(id);
    }

}
