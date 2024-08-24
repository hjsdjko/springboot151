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


import com.cl.dao.WeihurichenganpaiDao;
import com.cl.entity.WeihurichenganpaiEntity;
import com.cl.service.WeihurichenganpaiService;
import com.cl.entity.view.WeihurichenganpaiView;

@Service("weihurichenganpaiService")
public class WeihurichenganpaiServiceImpl extends ServiceImpl<WeihurichenganpaiDao, WeihurichenganpaiEntity> implements WeihurichenganpaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeihurichenganpaiEntity> page = this.selectPage(
                new Query<WeihurichenganpaiEntity>(params).getPage(),
                new EntityWrapper<WeihurichenganpaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeihurichenganpaiEntity> wrapper) {
		  Page<WeihurichenganpaiView> page =new Query<WeihurichenganpaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeihurichenganpaiView> selectListView(Wrapper<WeihurichenganpaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeihurichenganpaiView selectView(Wrapper<WeihurichenganpaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
