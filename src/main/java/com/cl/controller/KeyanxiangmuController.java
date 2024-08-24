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

import com.cl.entity.KeyanxiangmuEntity;
import com.cl.entity.view.KeyanxiangmuView;

import com.cl.service.KeyanxiangmuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 科研项目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/keyanxiangmu")
public class KeyanxiangmuController {
    @Autowired
    private KeyanxiangmuService keyanxiangmuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeyanxiangmuEntity keyanxiangmu,
		HttpServletRequest request){
        EntityWrapper<KeyanxiangmuEntity> ew = new EntityWrapper<KeyanxiangmuEntity>();

		PageUtils page = keyanxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanxiangmu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeyanxiangmuEntity keyanxiangmu, 
		HttpServletRequest request){
        EntityWrapper<KeyanxiangmuEntity> ew = new EntityWrapper<KeyanxiangmuEntity>();

		PageUtils page = keyanxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanxiangmu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeyanxiangmuEntity keyanxiangmu){
       	EntityWrapper<KeyanxiangmuEntity> ew = new EntityWrapper<KeyanxiangmuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keyanxiangmu, "keyanxiangmu")); 
        return R.ok().put("data", keyanxiangmuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeyanxiangmuEntity keyanxiangmu){
        EntityWrapper< KeyanxiangmuEntity> ew = new EntityWrapper< KeyanxiangmuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keyanxiangmu, "keyanxiangmu")); 
		KeyanxiangmuView keyanxiangmuView =  keyanxiangmuService.selectView(ew);
		return R.ok("查询科研项目成功").put("data", keyanxiangmuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeyanxiangmuEntity keyanxiangmu = keyanxiangmuService.selectById(id);
		keyanxiangmu = keyanxiangmuService.selectView(new EntityWrapper<KeyanxiangmuEntity>().eq("id", id));
        return R.ok().put("data", keyanxiangmu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeyanxiangmuEntity keyanxiangmu = keyanxiangmuService.selectById(id);
		keyanxiangmu = keyanxiangmuService.selectView(new EntityWrapper<KeyanxiangmuEntity>().eq("id", id));
        return R.ok().put("data", keyanxiangmu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanxiangmuEntity keyanxiangmu, HttpServletRequest request){
    	keyanxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanxiangmu);
        keyanxiangmuService.insert(keyanxiangmu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KeyanxiangmuEntity keyanxiangmu, HttpServletRequest request){
    	keyanxiangmu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanxiangmu);
        keyanxiangmuService.insert(keyanxiangmu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeyanxiangmuEntity keyanxiangmu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keyanxiangmu);
        keyanxiangmuService.updateById(keyanxiangmu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keyanxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
