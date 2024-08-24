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


import com.cl.dao.YusuanyuzijinDao;
import com.cl.entity.YusuanyuzijinEntity;
import com.cl.service.YusuanyuzijinService;
import com.cl.entity.view.YusuanyuzijinView;

@Service("yusuanyuzijinService")
public class YusuanyuzijinServiceImpl extends ServiceImpl<YusuanyuzijinDao, YusuanyuzijinEntity> implements YusuanyuzijinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YusuanyuzijinEntity> page = this.selectPage(
                new Query<YusuanyuzijinEntity>(params).getPage(),
                new EntityWrapper<YusuanyuzijinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YusuanyuzijinEntity> wrapper) {
		  Page<YusuanyuzijinView> page =new Query<YusuanyuzijinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YusuanyuzijinView> selectListView(Wrapper<YusuanyuzijinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YusuanyuzijinView selectView(Wrapper<YusuanyuzijinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
