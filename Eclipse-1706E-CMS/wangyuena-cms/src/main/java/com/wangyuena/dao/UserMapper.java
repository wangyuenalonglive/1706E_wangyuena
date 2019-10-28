package com.wangyuena.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wangyuena.entity.Article;
import com.wangyuena.entity.Commnent;
import com.wangyuena.entity.User;

/**
 * @author WYN
 * @time 2019年10月16日
 */
public interface UserMapper {


	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO cms_user(username,password,gender,create_time) "
			+ "values(#{username},#{password},#{gender},now())")
	int add(User user);
	
	/**
	 * 根据用户名查找
	 * @param username
	 * @return
	 */
	@Select("SELECT id,username,password,role FROM cms_user "
			+ "WHERE username=#{value} limit 1")
	User findByName(String username);

	List<User> list();
    
	@Update("update cms_user set locked=#{locked} where id=#{id}")
	int update(User user);
	
	@Update("update cms_user set head_picture=#{head_picture} where id=#{id}")
	int addHead_picture(User user);

	@Select("select c.*,u.username as userName from cms_comment c left join cms_user u on u.id=c.userId"
			+ " where u.id=#{value} ")
	List<Commnent> queryMyComment(Integer id);

	
}
