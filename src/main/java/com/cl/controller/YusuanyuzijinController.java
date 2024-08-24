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

import com.cl.entity.YusuanyuzijinEntity;
import com.cl.entity.view.YusuanyuzijinView;

import com.cl.service.YusuanyuzijinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预算与资金
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/yusuanyuzijin")
public class YusuanyuzijinController {
    @Autowired
    private YusuanyuzijinService yusuanyuzijinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YusuanyuzijinEntity yusuanyuzijin,
		HttpServletRequest request){
        EntityWrapper<YusuanyuzijinEntity> ew = new EntityWrapper<YusuanyuzijinEntity>();

		PageUtils page = yusuanyuzijinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yusuanyuzijin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YusuanyuzijinEntity yusuanyuzijin, 
		HttpServletRequest request){
        EntityWrapper<YusuanyuzijinEntity> ew = new EntityWrapper<YusuanyuzijinEntity>();

		PageUtils page = yusuanyuzijinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yusuanyuzijin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YusuanyuzijinEntity yusuanyuzijin){
       	EntityWrapper<YusuanyuzijinEntity> ew = new EntityWrapper<YusuanyuzijinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yusuanyuzijin, "yusuanyuzijin")); 
        return R.ok().put("data", yusuanyuzijinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YusuanyuzijinEntity yusuanyuzijin){
        EntityWrapper< YusuanyuzijinEntity> ew = new EntityWrapper< YusuanyuzijinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yusuanyuzijin, "yusuanyuzijin")); 
		YusuanyuzijinView yusuanyuzijinView =  yusuanyuzijinService.selectView(ew);
		return R.ok("查询预算与资金成功").put("data", yusuanyuzijinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YusuanyuzijinEntity yusuanyuzijin = yusuanyuzijinService.selectById(id);
		yusuanyuzijin = yusuanyuzijinService.selectView(new EntityWrapper<YusuanyuzijinEntity>().eq("id", id));
        return R.ok().put("data", yusuanyuzijin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YusuanyuzijinEntity yusuanyuzijin = yusuanyuzijinService.selectById(id);
		yusuanyuzijin = yusuanyuzijinService.selectView(new EntityWrapper<YusuanyuzijinEntity>().eq("id", id));
        return R.ok().put("data", yusuanyuzijin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YusuanyuzijinEntity yusuanyuzijin, HttpServletRequest request){
    	yusuanyuzijin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yusuanyuzijin);
        yusuanyuzijinService.insert(yusuanyuzijin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YusuanyuzijinEntity yusuanyuzijin, HttpServletRequest request){
    	yusuanyuzijin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yusuanyuzijin);
        yusuanyuzijinService.insert(yusuanyuzijin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YusuanyuzijinEntity yusuanyuzijin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yusuanyuzijin);
        yusuanyuzijinService.updateById(yusuanyuzijin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yusuanyuzijinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
