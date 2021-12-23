package com.djr.demo.account;

import com.djr.demo.TestUtils;
import com.djr.demo.account.BaseTest;
import com.djr.demo.pojo.Account;
import com.djr.demo.util.JSONResult;
import org.junit.Assert;
import org.junit.Test;

public class TestCase_CreateAccount extends BaseTest {

    @Test
    public void test2_1_insert(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("123");
        account.setBirthDate("birth");
        account.setGender(1);
        account.setPassword("123");
        account.setMobile("m1");
        account.setPlace("sd");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(jsonResult.getOk());
    }

    @Test
    public void test2_2_insert_name_null(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_3_insert_password_null(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("test");

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_4_insert_empty(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword("");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test2_5_insert_name_overlength(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName(TestUtils.buildString(256));
        account.setPassword("");

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_6_insert_password_overlength(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword(TestUtils.buildString(21));

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_7_insert_birthdate_overlength(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword("");
        account.setBirthDate(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_8_insert_place_overlength(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword("");
        account.setBirthDate("");
        account.setPlace(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_9_insert_mobile_overlength(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword("");
        account.setBirthDate("");
        account.setPlace("");
        account.setMobile(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.insert(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test2_10_insert_doublebytes(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("测试");
        account.setPassword("程序");
        account.setBirthDate("日期");
        account.setPlace("中国");
        account.setMobile("手机");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test2_11_insert_specialchars1(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setPassword("!@#$%^&*()_+{'");
        account.setBirthDate("日期");
        account.setPlace("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setMobile("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test2_11_insert_specialchars2(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setPassword("}|:'\"<>?\\-=[];',./'");
        account.setBirthDate("日期");
        account.setPlace("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setMobile("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test2_12_insert_duplicate(){
        Account account = new Account();
        account.setId(1);
        account.setName("123");
        account.setBirthDate("birth");
        account.setGender(1);
        account.setPassword("123");
        account.setMobile("m1");
        account.setPlace("sd");

        accountController.insert(account);
        JSONResult jsonResult = accountController.query(account.getId());
        Assert.assertTrue(jsonResult.getOk());
    }


}
