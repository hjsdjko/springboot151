package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanshebeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshebeiView;


/**
 * 实验设备
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShiyanshebeiService extends IService<ShiyanshebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanshebeiView> selectListView(Wrapper<ShiyanshebeiEntity> wrapper);
   	
   	ShiyanshebeiView selectView(@Param("ew") Wrapper<ShiyanshebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanshebeiEntity> wrapper);
   	

}

