package com.cl.dao;

import com.cl.entity.ShiyanshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshujuView;


/**
 * 实验数据
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShiyanshujuDao extends BaseMapper<ShiyanshujuEntity> {
	
	List<ShiyanshujuView> selectListView(@Param("ew") Wrapper<ShiyanshujuEntity> wrapper);

	List<ShiyanshujuView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyanshujuEntity> wrapper);
	
	ShiyanshujuView selectView(@Param("ew") Wrapper<ShiyanshujuEntity> wrapper);
	

}
