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

import com.cl.entity.HaocaikucunEntity;
import com.cl.entity.view.HaocaikucunView;

import com.cl.service.HaocaikucunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 耗材库存
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/haocaikucun")
public class HaocaikucunController {
    @Autowired
    private HaocaikucunService haocaikucunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HaocaikucunEntity haocaikucun,
		HttpServletRequest request){
        EntityWrapper<HaocaikucunEntity> ew = new EntityWrapper<HaocaikucunEntity>();

		PageUtils page = haocaikucunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haocaikucun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HaocaikucunEntity haocaikucun, 
		HttpServletRequest request){
        EntityWrapper<HaocaikucunEntity> ew = new EntityWrapper<HaocaikucunEntity>();

		PageUtils page = haocaikucunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haocaikucun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HaocaikucunEntity haocaikucun){
       	EntityWrapper<HaocaikucunEntity> ew = new EntityWrapper<HaocaikucunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( haocaikucun, "haocaikucun")); 
        return R.ok().put("data", haocaikucunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HaocaikucunEntity haocaikucun){
        EntityWrapper< HaocaikucunEntity> ew = new EntityWrapper< HaocaikucunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( haocaikucun, "haocaikucun")); 
		HaocaikucunView haocaikucunView =  haocaikucunService.selectView(ew);
		return R.ok("查询耗材库存成功").put("data", haocaikucunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HaocaikucunEntity haocaikucun = haocaikucunService.selectById(id);
		haocaikucun = haocaikucunService.selectView(new EntityWrapper<HaocaikucunEntity>().eq("id", id));
        return R.ok().put("data", haocaikucun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HaocaikucunEntity haocaikucun = haocaikucunService.selectById(id);
		haocaikucun = haocaikucunService.selectView(new EntityWrapper<HaocaikucunEntity>().eq("id", id));
        return R.ok().put("data", haocaikucun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HaocaikucunEntity haocaikucun, HttpServletRequest request){
    	haocaikucun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haocaikucun);
        haocaikucunService.insert(haocaikucun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HaocaikucunEntity haocaikucun, HttpServletRequest request){
    	haocaikucun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haocaikucun);
        haocaikucunService.insert(haocaikucun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HaocaikucunEntity haocaikucun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(haocaikucun);
        haocaikucunService.updateById(haocaikucun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        haocaikucunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
