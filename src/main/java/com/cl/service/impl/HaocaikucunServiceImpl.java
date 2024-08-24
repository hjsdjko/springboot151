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


import com.cl.dao.HaocaikucunDao;
import com.cl.entity.HaocaikucunEntity;
import com.cl.service.HaocaikucunService;
import com.cl.entity.view.HaocaikucunView;

@Service("haocaikucunService")
public class HaocaikucunServiceImpl extends ServiceImpl<HaocaikucunDao, HaocaikucunEntity> implements HaocaikucunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HaocaikucunEntity> page = this.selectPage(
                new Query<HaocaikucunEntity>(params).getPage(),
                new EntityWrapper<HaocaikucunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HaocaikucunEntity> wrapper) {
		  Page<HaocaikucunView> page =new Query<HaocaikucunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HaocaikucunView> selectListView(Wrapper<HaocaikucunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HaocaikucunView selectView(Wrapper<HaocaikucunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
