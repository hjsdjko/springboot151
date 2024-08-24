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

import com.cl.entity.WeihurenyuanEntity;
import com.cl.entity.view.WeihurenyuanView;

import com.cl.service.WeihurenyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维护人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/weihurenyuan")
public class WeihurenyuanController {
    @Autowired
    private WeihurenyuanService weihurenyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeihurenyuanEntity u = weihurenyuanService.selectOne(new EntityWrapper<WeihurenyuanEntity>().eq("weihuzhanghao", username));
        if(u==null || !u.getWeihumima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"weihurenyuan",  "维护人员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeihurenyuanEntity weihurenyuan){
    	//ValidatorUtils.validateEntity(weihurenyuan);
    	WeihurenyuanEntity u = weihurenyuanService.selectOne(new EntityWrapper<WeihurenyuanEntity>().eq("weihuzhanghao", weihurenyuan.getWeihuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weihurenyuan.setId(uId);
        weihurenyuanService.insert(weihurenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WeihurenyuanEntity u = weihurenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeihurenyuanEntity u = weihurenyuanService.selectOne(new EntityWrapper<WeihurenyuanEntity>().eq("weihuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setWeihumima("123456");
        weihurenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeihurenyuanEntity weihurenyuan,
		HttpServletRequest request){
        EntityWrapper<WeihurenyuanEntity> ew = new EntityWrapper<WeihurenyuanEntity>();

		PageUtils page = weihurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weihurenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeihurenyuanEntity weihurenyuan, 
		HttpServletRequest request){
        EntityWrapper<WeihurenyuanEntity> ew = new EntityWrapper<WeihurenyuanEntity>();

		PageUtils page = weihurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weihurenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeihurenyuanEntity weihurenyuan){
       	EntityWrapper<WeihurenyuanEntity> ew = new EntityWrapper<WeihurenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weihurenyuan, "weihurenyuan")); 
        return R.ok().put("data", weihurenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeihurenyuanEntity weihurenyuan){
        EntityWrapper< WeihurenyuanEntity> ew = new EntityWrapper< WeihurenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weihurenyuan, "weihurenyuan")); 
		WeihurenyuanView weihurenyuanView =  weihurenyuanService.selectView(ew);
		return R.ok("查询维护人员成功").put("data", weihurenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeihurenyuanEntity weihurenyuan = weihurenyuanService.selectById(id);
		weihurenyuan = weihurenyuanService.selectView(new EntityWrapper<WeihurenyuanEntity>().eq("id", id));
        return R.ok().put("data", weihurenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeihurenyuanEntity weihurenyuan = weihurenyuanService.selectById(id);
		weihurenyuan = weihurenyuanService.selectView(new EntityWrapper<WeihurenyuanEntity>().eq("id", id));
        return R.ok().put("data", weihurenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeihurenyuanEntity weihurenyuan, HttpServletRequest request){
    	weihurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weihurenyuan);
    	WeihurenyuanEntity u = weihurenyuanService.selectOne(new EntityWrapper<WeihurenyuanEntity>().eq("weihuzhanghao", weihurenyuan.getWeihuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weihurenyuan.setId(new Date().getTime());
        weihurenyuanService.insert(weihurenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeihurenyuanEntity weihurenyuan, HttpServletRequest request){
    	weihurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weihurenyuan);
    	WeihurenyuanEntity u = weihurenyuanService.selectOne(new EntityWrapper<WeihurenyuanEntity>().eq("weihuzhanghao", weihurenyuan.getWeihuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weihurenyuan.setId(new Date().getTime());
        weihurenyuanService.insert(weihurenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeihurenyuanEntity weihurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weihurenyuan);
        weihurenyuanService.updateById(weihurenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weihurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}