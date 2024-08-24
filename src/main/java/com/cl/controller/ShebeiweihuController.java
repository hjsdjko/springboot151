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

import com.cl.entity.ShebeiweihuEntity;
import com.cl.entity.view.ShebeiweihuView;

import com.cl.service.ShebeiweihuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备维护
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/shebeiweihu")
public class ShebeiweihuController {
    @Autowired
    private ShebeiweihuService shebeiweihuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeiweihuEntity shebeiweihu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weihurenyuan")) {
			shebeiweihu.setWeihuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShebeiweihuEntity> ew = new EntityWrapper<ShebeiweihuEntity>();

		PageUtils page = shebeiweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweihu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeiweihuEntity shebeiweihu, 
		HttpServletRequest request){
        EntityWrapper<ShebeiweihuEntity> ew = new EntityWrapper<ShebeiweihuEntity>();

		PageUtils page = shebeiweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweihu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeiweihuEntity shebeiweihu){
       	EntityWrapper<ShebeiweihuEntity> ew = new EntityWrapper<ShebeiweihuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeiweihu, "shebeiweihu")); 
        return R.ok().put("data", shebeiweihuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeiweihuEntity shebeiweihu){
        EntityWrapper< ShebeiweihuEntity> ew = new EntityWrapper< ShebeiweihuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeiweihu, "shebeiweihu")); 
		ShebeiweihuView shebeiweihuView =  shebeiweihuService.selectView(ew);
		return R.ok("查询设备维护成功").put("data", shebeiweihuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeiweihuEntity shebeiweihu = shebeiweihuService.selectById(id);
		shebeiweihu = shebeiweihuService.selectView(new EntityWrapper<ShebeiweihuEntity>().eq("id", id));
        return R.ok().put("data", shebeiweihu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeiweihuEntity shebeiweihu = shebeiweihuService.selectById(id);
		shebeiweihu = shebeiweihuService.selectView(new EntityWrapper<ShebeiweihuEntity>().eq("id", id));
        return R.ok().put("data", shebeiweihu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiweihuEntity shebeiweihu, HttpServletRequest request){
    	shebeiweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeiweihu);
        shebeiweihuService.insert(shebeiweihu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiweihuEntity shebeiweihu, HttpServletRequest request){
    	shebeiweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeiweihu);
        shebeiweihuService.insert(shebeiweihu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeiweihuEntity shebeiweihu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiweihu);
        shebeiweihuService.updateById(shebeiweihu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeiweihuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
