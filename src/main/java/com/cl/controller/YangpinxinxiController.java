package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YangpinxinxiEntity;
import com.cl.entity.view.YangpinxinxiView;

import com.cl.service.YangpinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 样品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/yangpinxinxi")
public class YangpinxinxiController {
    @Autowired
    private YangpinxinxiService yangpinxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangpinxinxiEntity yangpinxinxi,
                @RequestParam(required = false) Double shuliangstart,
                @RequestParam(required = false) Double shuliangend,
		HttpServletRequest request){
        EntityWrapper<YangpinxinxiEntity> ew = new EntityWrapper<YangpinxinxiEntity>();
                if(shuliangstart!=null) ew.ge("shuliang", shuliangstart);
                if(shuliangend!=null) ew.le("shuliang", shuliangend);

		PageUtils page = yangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YangpinxinxiEntity yangpinxinxi, 
                @RequestParam(required = false) Double shuliangstart,
                @RequestParam(required = false) Double shuliangend,
		HttpServletRequest request){
        EntityWrapper<YangpinxinxiEntity> ew = new EntityWrapper<YangpinxinxiEntity>();
                if(shuliangstart!=null) ew.ge("shuliang", shuliangstart);
                if(shuliangend!=null) ew.le("shuliang", shuliangend);

		PageUtils page = yangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangpinxinxiEntity yangpinxinxi){
       	EntityWrapper<YangpinxinxiEntity> ew = new EntityWrapper<YangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangpinxinxi, "yangpinxinxi")); 
        return R.ok().put("data", yangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangpinxinxiEntity yangpinxinxi){
        EntityWrapper< YangpinxinxiEntity> ew = new EntityWrapper< YangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangpinxinxi, "yangpinxinxi")); 
		YangpinxinxiView yangpinxinxiView =  yangpinxinxiService.selectView(ew);
		return R.ok("查询样品信息成功").put("data", yangpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangpinxinxiEntity yangpinxinxi = yangpinxinxiService.selectById(id);
		yangpinxinxi = yangpinxinxiService.selectView(new EntityWrapper<YangpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", yangpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangpinxinxiEntity yangpinxinxi = yangpinxinxiService.selectById(id);
		yangpinxinxi = yangpinxinxiService.selectView(new EntityWrapper<YangpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", yangpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YangpinxinxiEntity yangpinxinxi, HttpServletRequest request){
    	yangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yangpinxinxi);
        yangpinxinxiService.insert(yangpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YangpinxinxiEntity yangpinxinxi, HttpServletRequest request){
    	yangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yangpinxinxi);
        yangpinxinxiService.insert(yangpinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YangpinxinxiEntity yangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangpinxinxi);
        yangpinxinxiService.updateById(yangpinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
