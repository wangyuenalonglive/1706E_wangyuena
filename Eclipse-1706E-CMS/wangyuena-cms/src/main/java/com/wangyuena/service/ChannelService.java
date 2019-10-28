package com.wangyuena.service;

import java.util.List;

import com.wangyuena.entity.Channel;

/**
 * @author WYN
 * @time 2019年10月17日
 */
public interface ChannelService {

	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	List<Channel> getAllChnls();
}
