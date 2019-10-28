package com.wangyuena.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangyuena.dao.UserMapper;
import com.wangyuena.entity.Commnent;
import com.wangyuena.entity.User;
import com.wangyuena.service.UserService;
import com.wangyuena.utils.Md5Utils;

/**
 * @author WYN
 * @time 2019年10月16日
 */
@Service
public class UserServiceImpl  implements UserService {
	@Autowired
	UserMapper userMapper;
	

	/**
	 * 注册
	 */
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User existUser = userMapper.findByName(user.getUsername());
		if(existUser!=null) {
			return -1;// 用户已经存在
		}
		//设置密码密文
		user.setPassword(
				Md5Utils.md5(user.getPassword(),user.getUsername()));
		
		return userMapper.add(user);
		
	}

	@Override
	public User login(User user) {
		System.out.println("service");
		// TODO Auto-generated method stub
		// 获取密码密文
		String pwdStr = Md5Utils.md5(user.getPassword(),user.getUsername());
		//根据用户名称查找用户
		User loginUser =  userMapper.findByName(user.getUsername());
		//判断数据库中密码密文与与计算所得的密文是否相同
		if(loginUser!=null && pwdStr.equals(loginUser.getPassword())) {
			//登录成功
			return loginUser;
		}
		//登录失败
		return null;
	}

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	@Override
	public boolean checkUserExist(String username) {
		// TODO Auto-generated method stub
		return null!=userMapper.findByName(username);
		
	}
	/**
	 * 用户管理
	 */
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userMapper.list();
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	@Override
	public int addHead_picture(User user) {
		return userMapper.addHead_picture(user);
	}
	@Override
	public List<Commnent> queryMyComment(Integer id) {
		// TODO Auto-generated method stub
		return  userMapper.queryMyComment(id);
	}

}

