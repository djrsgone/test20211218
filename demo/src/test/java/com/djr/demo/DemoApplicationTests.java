package com.djr.demo;

import com.alibaba.fastjson.JSON;
import com.djr.demo.pojo.Account;
import com.djr.demo.service.AccountService;
import com.djr.demo.util.JSONResult;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
class DemoApplicationTests {

	private static AtomicInteger idGenerator = new AtomicInteger(10000);

	@Autowired
	private DataSourceConfiguration dataSourceConfiguration;

	@Test
	void contextLoads() {}

	@Resource
	private AccountService accountService;

	@Test
	void test0_queryAll(){
		JSONResult jsonResult = accountService.queryAll();
		Assert.assertTrue(jsonResult.getOk());

		List<Account> accounts = (List<Account>) jsonResult.getData();
		Assert.assertNotNull(accounts);
		Assert.assertTrue(accounts.size() >= 1);
	}

	@Test
	void test1_1_query_negative(){
		JSONResult jsonResult = accountService.query(-1);
		System.out.println(jsonResult);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	void test1_2_query_zero(){
		JSONResult jsonResult = accountService.query(0);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	void test1_3_query_positive(){
		JSONResult jsonResult = accountService.query(1);
		Assert.assertTrue(jsonResult.getOk());
	}

	@Test
	void test2_1_insert(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("123");
		account.setBirthDate("birth");
		account.setGender(1);
		account.setPassword("123");
		account.setMobile("m1");
		account.setPlace("sd");

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
		Assert.assertTrue(jsonResult.getOk());
	}

	@Test
	public void test2_2_insert_name_null(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());

		JSONResult jsonResult = this.accountService.insert(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test2_3_insert_password_null(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("test");

		JSONResult jsonResult = this.accountService.insert(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test2_4_insert_empty(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("");
		account.setPassword("");

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
		Assert.assertTrue(account.equals(jsonResult.getData()));
	}

	@Test
	public void test2_5_insert_name_overlength(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName(buildString(256));
		account.setPassword("");

		JSONResult jsonResult = this.accountService.insert(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test2_6_insert_password_overlength(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("");
		account.setPassword(buildString(21));

		JSONResult jsonResult = this.accountService.insert(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test2_7_insert_birthdate_overlength(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("");
		account.setPassword("");
		account.setBirthDate(buildString(256));

		JSONResult jsonResult = this.accountService.insert(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test2_8_insert_place_overlength(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("");
		account.setPassword("");
		account.setBirthDate("");
		account.setPlace(buildString(256));

		JSONResult jsonResult = this.accountService.insert(account);
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
		account.setMobile(buildString(256));

		JSONResult jsonResult = this.accountService.insert(account);
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

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
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

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
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

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
		Assert.assertTrue(account.equals(jsonResult.getData()));
	}

	@Test
	void test2_12_insert_duplicate(){
		Account account = new Account();
		account.setId(1);
		account.setName("123");
		account.setBirthDate("birth");
		account.setGender(1);
		account.setPassword("123");
		account.setMobile("m1");
		account.setPlace("sd");

		accountService.insert(account);
		JSONResult jsonResult = accountService.query(account.getId());
		Assert.assertTrue(jsonResult.getOk());
	}


	@Test
	public void test3_1_delete_existing(){
		final int id = idGenerator.incrementAndGet();
		Account account = new Account();
		account.setId(id);
		account.setName("12");
		account.setPassword("12");
		accountService.insert(account);
		Assert.assertNotNull(accountService.query(id));

		accountService.delete(id);
		JSONResult jsonResult = accountService.query(id);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test3_2_delete_unexisting(){
		final int id = -1;
		accountService.delete(id);
	}

	@Test
	void test4_1_update(){
		Account account = new Account();
		account.setId(1);
		account.setName("123");
		account.setBirthDate("birth");
		account.setGender(1);
		account.setPassword("123");
		account.setMobile("m1");
		account.setPlace("sd");

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertTrue(jsonResult.getOk());
	}

	@Test
	public void test4_2_update_name_null(){
		Account account = new Account();
		account.setId(1);

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test4_3_update_password_null(){
		Account account = new Account();
		account.setId(1);
		account.setName("test");

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test4_4_update_empty(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());
		account.setName("");
		account.setPassword("");

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertTrue(jsonResult.getOk());
	}

	@Test
	public void test4_5_update_name_overlength(){
		Account account = new Account();
		account.setId(1);
		account.setName(buildString(256));
		account.setPassword("");

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test4_6_update_password_overlength(){
		Account account = new Account();
		account.setId(1);
		account.setName("");
		account.setPassword(buildString(21));

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test4_7_update_birthdate_overlength(){
		Account account = new Account();
		account.setId(1);
		account.setName("");
		account.setPassword("");
		account.setBirthDate(buildString(256));

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertFalse(jsonResult.getOk());
	}

	@Test
	public void test4_8_update_place_overlength(){
		Account account = new Account();
		account.setId(1);
		account.setName("");
		account.setPassword("");
		account.setBirthDate("");
		account.setPlace(buildString(256));

		JSONResult jsonResult = this.accountService.update(account);
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
		account.setMobile(buildString(256));

		JSONResult jsonResult = this.accountService.update(account);
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

		JSONResult jsonResult = this.accountService.update(account);
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

		JSONResult jsonResult = this.accountService.update(account);
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

		JSONResult jsonResult = this.accountService.update(account);
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

		JSONResult jsonResult = this.accountService.update(account);
		Assert.assertTrue(account.equals(jsonResult.getData()));
	}

	@Test
	public void test4_13_update_null(){
		JSONResult jsonResult = this.accountService.update(null);
		Assert.assertFalse(jsonResult.getOk());
	}

//	private boolean hasInsertError(Account account){
//		boolean error = false;
//		try
//		{
//			accountService.insert(account);
//		}catch (Exception e){
//			error = true;
//		}
//		return error;
//	}

//	private boolean hasUpdateError(Account account){
//		boolean error = false;
//		try
//		{
//			accountService.update(account);
//		}catch (Exception e){
//			error = true;
//		}
//		return error;
//	}

	private static String buildString(int length){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < length; i++){
			char c = (char) ('0' + i % 10);
			buffer.append(c);
		}
		return buffer.toString();
	}
}
