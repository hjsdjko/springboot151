package com.cl.dao;

import com.cl.entity.WeihurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeihurenyuanView;


/**
 * 维护人员
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface WeihurenyuanDao extends BaseMapper<WeihurenyuanEntity> {
	
	List<WeihurenyuanView> selectListView(@Param("ew") Wrapper<WeihurenyuanEntity> wrapper);

	List<WeihurenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<WeihurenyuanEntity> wrapper);
	
	WeihurenyuanView selectView(@Param("ew") Wrapper<WeihurenyuanEntity> wrapper);
	

}
