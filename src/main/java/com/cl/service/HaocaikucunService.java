package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HaocaikucunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HaocaikucunView;


/**
 * 耗材库存
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface HaocaikucunService extends IService<HaocaikucunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaocaikucunView> selectListView(Wrapper<HaocaikucunEntity> wrapper);
   	
   	HaocaikucunView selectView(@Param("ew") Wrapper<HaocaikucunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaocaikucunEntity> wrapper);
   	

}

