package com.cl.dao;

import com.cl.entity.HaocaikucunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HaocaikucunView;


/**
 * 耗材库存
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface HaocaikucunDao extends BaseMapper<HaocaikucunEntity> {
	
	List<HaocaikucunView> selectListView(@Param("ew") Wrapper<HaocaikucunEntity> wrapper);

	List<HaocaikucunView> selectListView(Pagination page,@Param("ew") Wrapper<HaocaikucunEntity> wrapper);
	
	HaocaikucunView selectView(@Param("ew") Wrapper<HaocaikucunEntity> wrapper);
	

}
