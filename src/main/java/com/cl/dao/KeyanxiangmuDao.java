package com.cl.dao;

import com.cl.entity.KeyanxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanxiangmuView;


/**
 * 科研项目
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface KeyanxiangmuDao extends BaseMapper<KeyanxiangmuEntity> {
	
	List<KeyanxiangmuView> selectListView(@Param("ew") Wrapper<KeyanxiangmuEntity> wrapper);

	List<KeyanxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<KeyanxiangmuEntity> wrapper);
	
	KeyanxiangmuView selectView(@Param("ew") Wrapper<KeyanxiangmuEntity> wrapper);
	

}
