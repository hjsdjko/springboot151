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


import com.cl.dao.YangpinxinxiDao;
import com.cl.entity.YangpinxinxiEntity;
import com.cl.service.YangpinxinxiService;
import com.cl.entity.view.YangpinxinxiView;

@Service("yangpinxinxiService")
public class YangpinxinxiServiceImpl extends ServiceImpl<YangpinxinxiDao, YangpinxinxiEntity> implements YangpinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangpinxinxiEntity> page = this.selectPage(
                new Query<YangpinxinxiEntity>(params).getPage(),
                new EntityWrapper<YangpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangpinxinxiEntity> wrapper) {
		  Page<YangpinxinxiView> page =new Query<YangpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YangpinxinxiView> selectListView(Wrapper<YangpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangpinxinxiView selectView(Wrapper<YangpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}