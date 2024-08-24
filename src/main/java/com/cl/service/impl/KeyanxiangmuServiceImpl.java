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


import com.cl.dao.KeyanxiangmuDao;
import com.cl.entity.KeyanxiangmuEntity;
import com.cl.service.KeyanxiangmuService;
import com.cl.entity.view.KeyanxiangmuView;

@Service("keyanxiangmuService")
public class KeyanxiangmuServiceImpl extends ServiceImpl<KeyanxiangmuDao, KeyanxiangmuEntity> implements KeyanxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeyanxiangmuEntity> page = this.selectPage(
                new Query<KeyanxiangmuEntity>(params).getPage(),
                new EntityWrapper<KeyanxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KeyanxiangmuEntity> wrapper) {
		  Page<KeyanxiangmuView> page =new Query<KeyanxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KeyanxiangmuView> selectListView(Wrapper<KeyanxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KeyanxiangmuView selectView(Wrapper<KeyanxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
