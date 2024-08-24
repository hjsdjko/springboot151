package com.cl.dao;

import com.cl.entity.WeihurichenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeihurichenganpaiView;


/**
 * 维护日程安排
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface WeihurichenganpaiDao extends BaseMapper<WeihurichenganpaiEntity> {
	
	List<WeihurichenganpaiView> selectListView(@Param("ew") Wrapper<WeihurichenganpaiEntity> wrapper);

	List<WeihurichenganpaiView> selectListView(Pagination page,@Param("ew") Wrapper<WeihurichenganpaiEntity> wrapper);
	
	WeihurichenganpaiView selectView(@Param("ew") Wrapper<WeihurichenganpaiEntity> wrapper);
	

}
