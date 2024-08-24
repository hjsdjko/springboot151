package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YusuanyuzijinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YusuanyuzijinView;


/**
 * 预算与资金
 *
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
public interface YusuanyuzijinService extends IService<YusuanyuzijinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YusuanyuzijinView> selectListView(Wrapper<YusuanyuzijinEntity> wrapper);
   	
   	YusuanyuzijinView selectView(@Param("ew") Wrapper<YusuanyuzijinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YusuanyuzijinEntity> wrapper);
   	

}

