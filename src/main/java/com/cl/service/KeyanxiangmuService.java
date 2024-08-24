package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KeyanxiangmuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanxiangmuView;


/**
 * 科研项目
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface KeyanxiangmuService extends IService<KeyanxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeyanxiangmuView> selectListView(Wrapper<KeyanxiangmuEntity> wrapper);
   	
   	KeyanxiangmuView selectView(@Param("ew") Wrapper<KeyanxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeyanxiangmuEntity> wrapper);
   	

}

