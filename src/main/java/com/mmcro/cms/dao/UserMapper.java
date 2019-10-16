package com.mmcro.cms.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mmcro.cms.entity.User;

public interface UserMapper {

	@Insert("INSERT INTO cms_user(username,password,gender,create_time) "
			+ "values(#{username},#{password},#{gender},now())")
	int add(User user);
	
	@Select("SELECT id,username,password FROM cms_user where username=#{value} limit 1")
	User findByName(String username);
	

}
