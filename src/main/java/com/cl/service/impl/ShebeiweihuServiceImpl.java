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


import com.cl.dao.ShebeiweihuDao;
import com.cl.entity.ShebeiweihuEntity;
import com.cl.service.ShebeiweihuService;
import com.cl.entity.view.ShebeiweihuView;

@Service("shebeiweihuService")
public class ShebeiweihuServiceImpl extends ServiceImpl<ShebeiweihuDao, ShebeiweihuEntity> implements ShebeiweihuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeiweihuEntity> page = this.selectPage(
                new Query<ShebeiweihuEntity>(params).getPage(),
                new EntityWrapper<ShebeiweihuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeiweihuEntity> wrapper) {
		  Page<ShebeiweihuView> page =new Query<ShebeiweihuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShebeiweihuView> selectListView(Wrapper<ShebeiweihuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeiweihuView selectView(Wrapper<ShebeiweihuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
