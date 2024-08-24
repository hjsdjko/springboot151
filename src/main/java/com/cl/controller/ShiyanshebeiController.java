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

import com.cl.entity.ShiyanshebeiEntity;
import com.cl.entity.view.ShiyanshebeiView;

import com.cl.service.ShiyanshebeiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验设备
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/shiyanshebei")
public class ShiyanshebeiController {
    @Autowired
    private ShiyanshebeiService shiyanshebeiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyanshebeiEntity shiyanshebei,
		HttpServletRequest request){
        EntityWrapper<ShiyanshebeiEntity> ew = new EntityWrapper<ShiyanshebeiEntity>();

		PageUtils page = shiyanshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshebei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyanshebeiEntity shiyanshebei, 
		HttpServletRequest request){
        EntityWrapper<ShiyanshebeiEntity> ew = new EntityWrapper<ShiyanshebeiEntity>();

		PageUtils page = shiyanshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshebei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyanshebeiEntity shiyanshebei){
       	EntityWrapper<ShiyanshebeiEntity> ew = new EntityWrapper<ShiyanshebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyanshebei, "shiyanshebei")); 
        return R.ok().put("data", shiyanshebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyanshebeiEntity shiyanshebei){
        EntityWrapper< ShiyanshebeiEntity> ew = new EntityWrapper< ShiyanshebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyanshebei, "shiyanshebei")); 
		ShiyanshebeiView shiyanshebeiView =  shiyanshebeiService.selectView(ew);
		return R.ok("查询实验设备成功").put("data", shiyanshebeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyanshebeiEntity shiyanshebei = shiyanshebeiService.selectById(id);
		shiyanshebei = shiyanshebeiService.selectView(new EntityWrapper<ShiyanshebeiEntity>().eq("id", id));
        return R.ok().put("data", shiyanshebei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyanshebeiEntity shiyanshebei = shiyanshebeiService.selectById(id);
		shiyanshebei = shiyanshebeiService.selectView(new EntityWrapper<ShiyanshebeiEntity>().eq("id", id));
        return R.ok().put("data", shiyanshebei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanshebeiEntity shiyanshebei, HttpServletRequest request){
    	shiyanshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshebei);
        shiyanshebeiService.insert(shiyanshebei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyanshebeiEntity shiyanshebei, HttpServletRequest request){
    	shiyanshebei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshebei);
        shiyanshebeiService.insert(shiyanshebei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyanshebeiEntity shiyanshebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyanshebei);
        shiyanshebeiService.updateById(shiyanshebei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyanshebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
