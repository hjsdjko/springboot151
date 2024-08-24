package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeihurenyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeihurenyuanView;


/**
 * 维护人员
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface WeihurenyuanService extends IService<WeihurenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeihurenyuanView> selectListView(Wrapper<WeihurenyuanEntity> wrapper);
   	
   	WeihurenyuanView selectView(@Param("ew") Wrapper<WeihurenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeihurenyuanEntity> wrapper);
   	

}

