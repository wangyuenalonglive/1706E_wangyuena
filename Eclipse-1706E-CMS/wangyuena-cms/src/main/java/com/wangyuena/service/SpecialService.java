package com.wangyuena.service;

import java.util.List;

import com.wangyuena.entity.Special;

public interface SpecialService {

	/**
	 * 
	 * @return
	 */
	List<Special> list();

	/**
	 * 
	 * @param special
	 * @return
	 */
	int add(Special special);

	/**
	 * 查看专题详情
	 * @param id
	 * @return
	 */
	Special findById(Integer id);

	/**
	 * 向专题中添加文章
	 * @param specId
	 * @param articleId
	 * @return
	 */
	int addArticle(Integer specId, Integer articleId);

	/**
	 * 移除文章
	 * @param specId
	 * @param articleId
	 * @return
	 */
	int removeArticle(Integer specId, Integer articleId);

	int update(Special special);

}
