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


import com.cl.dao.ShiyanshujuDao;
import com.cl.entity.ShiyanshujuEntity;
import com.cl.service.ShiyanshujuService;
import com.cl.entity.view.ShiyanshujuView;

@Service("shiyanshujuService")
public class ShiyanshujuServiceImpl extends ServiceImpl<ShiyanshujuDao, ShiyanshujuEntity> implements ShiyanshujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyanshujuEntity> page = this.selectPage(
                new Query<ShiyanshujuEntity>(params).getPage(),
                new EntityWrapper<ShiyanshujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyanshujuEntity> wrapper) {
		  Page<ShiyanshujuView> page =new Query<ShiyanshujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiyanshujuView> selectListView(Wrapper<ShiyanshujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyanshujuView selectView(Wrapper<ShiyanshujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
