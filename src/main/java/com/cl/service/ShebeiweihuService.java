package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShebeiweihuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeiweihuView;


/**
 * 设备维护
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface ShebeiweihuService extends IService<ShebeiweihuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeiweihuView> selectListView(Wrapper<ShebeiweihuEntity> wrapper);
   	
   	ShebeiweihuView selectView(@Param("ew") Wrapper<ShebeiweihuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeiweihuEntity> wrapper);
   	

}

