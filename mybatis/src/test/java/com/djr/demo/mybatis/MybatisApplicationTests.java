package com.djr.demo.mybatis;

import com.djr.demo.mybatis.pojo.User;
import com.djr.demo.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@Test
	public void testCreate(){
		User user = new User();
		user.setId(3);
		user.setUsername("mytest");
		user.setPassword("123");
		userService.create(user);
	}

}
