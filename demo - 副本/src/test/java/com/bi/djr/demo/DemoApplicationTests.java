package com.bi.djr.demo;

import com.bi.djr.demo.pojo.Account;
import com.bi.djr.demo.service.AccountService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.bi.djr.demo.DemoApplication.class})
class DemoApplicationTests {

	private static AtomicInteger idGenerator = new AtomicInteger(10000);

	@Autowired
	private DataSourceConfiguration dataSourceConfiguration;

	@Test
	void contextLoads() {
	}

	@Resource
	private AccountService accountService;

	@Test
	void test1_1_query_negative(){
		Account account = accountService.query(-1);
		Assert.assertNull(account);
	}

	@Test
	void test1_2_query_zero(){
		Account account = accountService.query(0);
		Assert.assertNull(account);
	}

	@Test
	void test1_3_query_positive(){
		Account account = accountService.query(1);
		Assert.assertNull(account);
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
		Account result = accountService.query(account.getId());
		Assert.assertEquals(account, result);
	}

	@Test
	void test2_2_insert_null(){
		Account account = new Account();
		account.setId(idGenerator.incrementAndGet());

		accountService.insert(account);
		Account result = accountService.query(account.getId());
		Assert.assertEquals(account, result);
	}

}
