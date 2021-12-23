package com.djr.demo.account;

import com.djr.demo.TestUtils;
import com.djr.demo.account.BaseTest;
import com.djr.demo.pojo.Account;
import com.djr.demo.util.JSONResult;
import org.junit.Assert;
import org.junit.Test;

public class TestCase_UpdateAccount extends BaseTest {

    @Test
    public void test4_1_update(){
        Account account = new Account();
        account.setId(1);
        account.setName("123");
        account.setBirthDate("birth");
        account.setGender(1);
        account.setPassword("123");
        account.setMobile("m1");
        account.setPlace("sd");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(jsonResult.getOk());
    }

    @Test
    public void test4_2_update_name_null(){
        Account account = new Account();
        account.setId(1);

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_3_update_password_null(){
        Account account = new Account();
        account.setId(1);
        account.setName("test");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_4_update_empty(){
        Account account = new Account();
        account.setId(idGenerator.incrementAndGet());
        account.setName("");
        account.setPassword("");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(jsonResult.getOk());
    }

    @Test
    public void test4_5_update_name_overlength(){
        Account account = new Account();
        account.setId(1);
        account.setName(TestUtils.buildString(256));
        account.setPassword("");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_6_update_password_overlength(){
        Account account = new Account();
        account.setId(1);
        account.setName("");
        account.setPassword(TestUtils.buildString(21));

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_7_update_birthdate_overlength(){
        Account account = new Account();
        account.setId(1);
        account.setName("");
        account.setPassword("");
        account.setBirthDate(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_8_update_place_overlength(){
        Account account = new Account();
        account.setId(1);
        account.setName("");
        account.setPassword("");
        account.setBirthDate("");
        account.setPlace(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_9_update_mobile_overlength(){
        Account account = new Account();
        account.setId(1);
        account.setName("");
        account.setPassword("");
        account.setBirthDate("");
        account.setPlace("");
        account.setMobile(TestUtils.buildString(256));

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertFalse(jsonResult.getOk());
    }

    @Test
    public void test4_10_update_doublebytes(){
        Account account = new Account();
        account.setId(1);
        account.setName("测试");
        account.setPassword("程序");
        account.setBirthDate("日期");
        account.setPlace("中国");
        account.setMobile("手机");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test4_11_update_specialchars1(){
        Account account = new Account();
        account.setId(1);
        account.setName("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setPassword("!@#$%^&*()_+{'");
        account.setBirthDate("日期");
        account.setPlace("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setMobile("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test4_11_update_specialchars2(){
        Account account = new Account();
        account.setId(1);
        account.setName("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setPassword("}|:'\"<>?\\-=[];',./'");
        account.setBirthDate("日期");
        account.setPlace("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setMobile("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test4_12_update_unexisting(){
        Account account = new Account();
        account.setId(10000000);
        account.setName("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setPassword("}|:'\"<>?\\-=[];',./'");
        account.setBirthDate("日期");
        account.setPlace("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");
        account.setMobile("!@#$%^&*()_+{}|:'\"<>?\\-=[];',./'");

        JSONResult jsonResult = this.accountController.update(account);
        Assert.assertTrue(account.equals(jsonResult.getData()));
    }

    @Test
    public void test4_13_update_null(){
        JSONResult jsonResult = this.accountController.update(null);
        Assert.assertFalse(jsonResult.getOk());
    }
}
