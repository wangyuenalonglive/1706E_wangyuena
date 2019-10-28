package com.wangyuena.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangyuena.common.CMSRuntimeException;
import com.wangyuena.dao.LinkMapper;
import com.wangyuena.entity.Link;
import com.wangyuena.service.LinkService;
import com.wangyuena.utils.StringUtils;

@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> linklist() {
		// TODO Auto-generated method stub
		return linkMapper.linklist();
	}

	@Override
	public int addlink(Link link) {
		// TODO Auto-generated method stub
		return linkMapper.addlink(link);
	}
	//友情链接的删除
	@Override
	public int deletelink(Integer id) {
		// TODO Auto-generated method stub
		return linkMapper.deletelink(id);
	}

	@Override
	public int addLink(String url) {
		// TODO Auto-generated method stub
		if(!StringUtils.isUrl(url)) {
			throw new CMSRuntimeException();
		}
		
		return 0;
	}

	/*@Override
	public int linkupdate(Integer id) {
		// TODO Auto-generated method stub
		return linkMapper.linkupdate(id);
	}
	*/
}
