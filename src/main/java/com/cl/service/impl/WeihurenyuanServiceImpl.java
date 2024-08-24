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


import com.cl.dao.WeihurenyuanDao;
import com.cl.entity.WeihurenyuanEntity;
import com.cl.service.WeihurenyuanService;
import com.cl.entity.view.WeihurenyuanView;

@Service("weihurenyuanService")
public class WeihurenyuanServiceImpl extends ServiceImpl<WeihurenyuanDao, WeihurenyuanEntity> implements WeihurenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeihurenyuanEntity> page = this.selectPage(
                new Query<WeihurenyuanEntity>(params).getPage(),
                new EntityWrapper<WeihurenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeihurenyuanEntity> wrapper) {
		  Page<WeihurenyuanView> page =new Query<WeihurenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeihurenyuanView> selectListView(Wrapper<WeihurenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeihurenyuanView selectView(Wrapper<WeihurenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
