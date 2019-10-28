package com.wangyuena.service;

import java.util.List;

import com.wangyuena.entity.Cat;

/**
 * @author WYN
 * @time 2019年10月17日
 */
public interface CatService {
	/**
	 * 根据频道去获取下边的分类
	 * @param id
	 * @return
	 */
	List<Cat> getListByChnlId(Integer id);  
	
}
