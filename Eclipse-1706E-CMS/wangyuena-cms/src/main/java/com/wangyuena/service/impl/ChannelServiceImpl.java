package com.wangyuena.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangyuena.dao.ChannelMapper;
import com.wangyuena.entity.Channel;
import com.wangyuena.service.ChannelService;

/**
 * @author WYN
 * @time 2019年10月17日
 */
@Service
public class ChannelServiceImpl implements ChannelService{

	@Autowired
	ChannelMapper channelMapper;
	
	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	@Override
	public List<Channel> getAllChnls() {
		// TODO Auto-generated method stub
		return channelMapper.listAll();
	
	}
}

