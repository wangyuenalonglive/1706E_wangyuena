package com.wangyuena.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangyuena.entity.User;

public class TestUser  extends BaseTest{
	
	@Autowired
	UserService userServie;
	
	@Test
	public void testRegister() {
		
		User user = new User("zhangsan222","password",1);
		int register = userServie.register(user);
		assertTrue(register>0);
		
		
	}

}
