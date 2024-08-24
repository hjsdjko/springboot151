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

import com.cl.entity.ShiyanshujuEntity;
import com.cl.entity.view.ShiyanshujuView;

import com.cl.service.ShiyanshujuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实验数据
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/shiyanshuju")
public class ShiyanshujuController {
    @Autowired
    private ShiyanshujuService shiyanshujuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyanshujuEntity shiyanshuju,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shiyanriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shiyanriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("keyanrenyuan")) {
			shiyanshuju.setKeyanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShiyanshujuEntity> ew = new EntityWrapper<ShiyanshujuEntity>();
                if(shiyanriqistart!=null) ew.ge("shiyanriqi", shiyanriqistart);
                if(shiyanriqiend!=null) ew.le("shiyanriqi", shiyanriqiend);

		PageUtils page = shiyanshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshuju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyanshujuEntity shiyanshuju, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shiyanriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shiyanriqiend,
		HttpServletRequest request){
        EntityWrapper<ShiyanshujuEntity> ew = new EntityWrapper<ShiyanshujuEntity>();
                if(shiyanriqistart!=null) ew.ge("shiyanriqi", shiyanriqistart);
                if(shiyanriqiend!=null) ew.le("shiyanriqi", shiyanriqiend);

		PageUtils page = shiyanshujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyanshuju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyanshujuEntity shiyanshuju){
       	EntityWrapper<ShiyanshujuEntity> ew = new EntityWrapper<ShiyanshujuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyanshuju, "shiyanshuju")); 
        return R.ok().put("data", shiyanshujuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyanshujuEntity shiyanshuju){
        EntityWrapper< ShiyanshujuEntity> ew = new EntityWrapper< ShiyanshujuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyanshuju, "shiyanshuju")); 
		ShiyanshujuView shiyanshujuView =  shiyanshujuService.selectView(ew);
		return R.ok("查询实验数据成功").put("data", shiyanshujuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyanshujuEntity shiyanshuju = shiyanshujuService.selectById(id);
		shiyanshuju = shiyanshujuService.selectView(new EntityWrapper<ShiyanshujuEntity>().eq("id", id));
        return R.ok().put("data", shiyanshuju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyanshujuEntity shiyanshuju = shiyanshujuService.selectById(id);
		shiyanshuju = shiyanshujuService.selectView(new EntityWrapper<ShiyanshujuEntity>().eq("id", id));
        return R.ok().put("data", shiyanshuju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanshujuEntity shiyanshuju, HttpServletRequest request){
    	shiyanshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshuju);
        shiyanshujuService.insert(shiyanshuju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyanshujuEntity shiyanshuju, HttpServletRequest request){
    	shiyanshuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiyanshuju);
        shiyanshujuService.insert(shiyanshuju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyanshujuEntity shiyanshuju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyanshuju);
        shiyanshujuService.updateById(shiyanshuju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyanshujuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
