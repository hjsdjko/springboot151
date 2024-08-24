package com.cl.dao;

import com.cl.entity.KeyanrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanrenyuanView;


/**
 * 科研人员
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface KeyanrenyuanDao extends BaseMapper<KeyanrenyuanEntity> {
	
	List<KeyanrenyuanView> selectListView(@Param("ew") Wrapper<KeyanrenyuanEntity> wrapper);

	List<KeyanrenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KeyanrenyuanEntity> wrapper);
	
	KeyanrenyuanView selectView(@Param("ew") Wrapper<KeyanrenyuanEntity> wrapper);
	

}
