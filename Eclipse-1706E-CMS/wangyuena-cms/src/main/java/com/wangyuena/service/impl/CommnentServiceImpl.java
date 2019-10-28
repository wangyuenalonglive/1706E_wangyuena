package com.wangyuena.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangyuena.dao.CommnentMapper;
import com.wangyuena.entity.Article;
import com.wangyuena.entity.Commnent;
import com.wangyuena.service.CommnentService;

@Service
public class CommnentServiceImpl implements CommnentService {

	@Autowired
	CommnentMapper commnentMapper;
	
	@Override
	public int commnentinsert(Commnent commnent) {
		// TODO Auto-generated method stub
	Article article = new Article();
	
	article.setId(commnent.getArticleId());
	
	int i = commnentMapper.updateCommnents(article);
		return commnentMapper.insert(commnent) ;
	}

}
