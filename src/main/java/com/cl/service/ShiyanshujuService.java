package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiyanshujuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiyanshujuView;


/**
 * 实验数据
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShiyanshujuService extends IService<ShiyanshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyanshujuView> selectListView(Wrapper<ShiyanshujuEntity> wrapper);
   	
   	ShiyanshujuView selectView(@Param("ew") Wrapper<ShiyanshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyanshujuEntity> wrapper);
   	

}

