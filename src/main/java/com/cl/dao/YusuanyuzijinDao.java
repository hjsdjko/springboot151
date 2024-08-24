package com.cl.dao;

import com.cl.entity.YusuanyuzijinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YusuanyuzijinView;


/**
 * 预算与资金
 * 
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface YusuanyuzijinDao extends BaseMapper<YusuanyuzijinEntity> {
	
	List<YusuanyuzijinView> selectListView(@Param("ew") Wrapper<YusuanyuzijinEntity> wrapper);

	List<YusuanyuzijinView> selectListView(Pagination page,@Param("ew") Wrapper<YusuanyuzijinEntity> wrapper);
	
	YusuanyuzijinView selectView(@Param("ew") Wrapper<YusuanyuzijinEntity> wrapper);
	

}
