package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KeyanrenyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanrenyuanView;


/**
 * 科研人员
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface KeyanrenyuanService extends IService<KeyanrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeyanrenyuanView> selectListView(Wrapper<KeyanrenyuanEntity> wrapper);
   	
   	KeyanrenyuanView selectView(@Param("ew") Wrapper<KeyanrenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeyanrenyuanEntity> wrapper);
   	

}

