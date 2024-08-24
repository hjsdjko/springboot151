package com.cl.dao;

import com.cl.entity.ShiyanshebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshebeiView;


/**
 * 实验设备
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShiyanshebeiDao extends BaseMapper<ShiyanshebeiEntity> {
	
	List<ShiyanshebeiView> selectListView(@Param("ew") Wrapper<ShiyanshebeiEntity> wrapper);

	List<ShiyanshebeiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanshebeiEntity> wrapper);
	
	ShiyanshebeiView selectView(@Param("ew") Wrapper<ShiyanshebeiEntity> wrapper);
	

}
