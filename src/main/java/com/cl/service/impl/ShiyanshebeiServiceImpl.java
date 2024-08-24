package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShiyanshebeiDao;
import com.cl.entity.ShiyanshebeiEntity;
import com.cl.service.ShiyanshebeiService;
import com.cl.entity.view.ShiyanshebeiView;

@Service("shiyanshebeiService")
public class ShiyanshebeiServiceImpl extends ServiceImpl<ShiyanshebeiDao, ShiyanshebeiEntity> implements ShiyanshebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyanshebeiEntity> page = this.selectPage(
                new Query<ShiyanshebeiEntity>(params).getPage(),
                new EntityWrapper<ShiyanshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyanshebeiEntity> wrapper) {
		  Page<ShiyanshebeiView> page =new Query<ShiyanshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiyanshebeiView> selectListView(Wrapper<ShiyanshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyanshebeiView selectView(Wrapper<ShiyanshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
