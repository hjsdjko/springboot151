package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeihurichenganpaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeihurichenganpaiView;


/**
 * 维护日程安排
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface WeihurichenganpaiService extends IService<WeihurichenganpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeihurichenganpaiView> selectListView(Wrapper<WeihurichenganpaiEntity> wrapper);
   	
   	WeihurichenganpaiView selectView(@Param("ew") Wrapper<WeihurichenganpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeihurichenganpaiEntity> wrapper);
   	

}

