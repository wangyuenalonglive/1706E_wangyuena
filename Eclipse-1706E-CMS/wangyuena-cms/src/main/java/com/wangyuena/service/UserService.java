package com.wangyuena.service;

import java.util.List;

import com.wangyuena.entity.Article;
import com.wangyuena.entity.Commnent;
import com.wangyuena.entity.User;

/**
 * @author WYN
 * @time 2019年10月16日
 */
public interface UserService {

	int register(User user) ;
	User login(User user);
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	boolean checkUserExist(String username);
	
	List<User> list();
	int update(User user);
	
	int addHead_picture(User user);
	
	List<Commnent> queryMyComment(Integer id);
}
