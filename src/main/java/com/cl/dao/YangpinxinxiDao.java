package com.cl.dao;

import com.cl.entity.YangpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YangpinxinxiView;


/**
 * 样品信息
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface YangpinxinxiDao extends BaseMapper<YangpinxinxiEntity> {
	
	List<YangpinxinxiView> selectListView(@Param("ew") Wrapper<YangpinxinxiEntity> wrapper);

	List<YangpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YangpinxinxiEntity> wrapper);
	
	YangpinxinxiView selectView(@Param("ew") Wrapper<YangpinxinxiEntity> wrapper);
	

}
