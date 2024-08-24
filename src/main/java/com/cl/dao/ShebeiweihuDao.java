package com.cl.dao;

import com.cl.entity.ShebeiweihuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeiweihuView;


/**
 * 设备维护
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShebeiweihuDao extends BaseMapper<ShebeiweihuEntity> {
	
	List<ShebeiweihuView> selectListView(@Param("ew") Wrapper<ShebeiweihuEntity> wrapper);

	List<ShebeiweihuView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeiweihuEntity> wrapper);
	
	ShebeiweihuView selectView(@Param("ew") Wrapper<ShebeiweihuEntity> wrapper);
	

}
