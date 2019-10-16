package com.mmcro.cms.service;

import com.mmcro.cms.entity.User;

public interface UserService {
	
	int register(User user) ;
	User login(User user);
	
	boolean checkUserExist(String username);
	

}
