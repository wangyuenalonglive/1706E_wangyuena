package com.wangyuena.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wangyuena.entity.Cat;

/**
 * @author WYN
 * @time 2019年10月17日
 */
@Mapper
public interface CatMapper {
	/**
	 * 
	 * @param chnlId 频道主键id
	 * @return
	 */
	@Select("SELECT id,name,channel_id channelId "
			+ " FROM cms_category "
			+ " WHERE channel_id=#{value}")
	List<Cat> selectByChnlId(Integer chnlId);
	
	
	/**
	 *  根据id获取对应的分类
	 * @param id
	 * @return
	 */
	/*@Select("SELECT * FROM cms_category WHERE id = #{value} limit 1")*/
	Cat findById(Integer id);

}
