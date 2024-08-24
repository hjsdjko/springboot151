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

import com.cl.entity.KeyanrenyuanEntity;
import com.cl.entity.view.KeyanrenyuanView;

import com.cl.service.KeyanrenyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 科研人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@RestController
@RequestMapping("/keyanrenyuan")
public class KeyanrenyuanController {
    @Autowired
    private KeyanrenyuanService keyanrenyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		KeyanrenyuanEntity u = keyanrenyuanService.selectOne(new EntityWrapper<KeyanrenyuanEntity>().eq("keyanzhanghao", username));
        if(u==null || !u.getKeyanmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"keyanrenyuan",  "科研人员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KeyanrenyuanEntity keyanrenyuan){
    	//ValidatorUtils.validateEntity(keyanrenyuan);
    	KeyanrenyuanEntity u = keyanrenyuanService.selectOne(new EntityWrapper<KeyanrenyuanEntity>().eq("keyanzhanghao", keyanrenyuan.getKeyanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		keyanrenyuan.setId(uId);
        keyanrenyuanService.insert(keyanrenyuan);
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
        KeyanrenyuanEntity u = keyanrenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	KeyanrenyuanEntity u = keyanrenyuanService.selectOne(new EntityWrapper<KeyanrenyuanEntity>().eq("keyanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setKeyanmima("123456");
        keyanrenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeyanrenyuanEntity keyanrenyuan,
		HttpServletRequest request){
        EntityWrapper<KeyanrenyuanEntity> ew = new EntityWrapper<KeyanrenyuanEntity>();

		PageUtils page = keyanrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanrenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeyanrenyuanEntity keyanrenyuan, 
		HttpServletRequest request){
        EntityWrapper<KeyanrenyuanEntity> ew = new EntityWrapper<KeyanrenyuanEntity>();

		PageUtils page = keyanrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanrenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeyanrenyuanEntity keyanrenyuan){
       	EntityWrapper<KeyanrenyuanEntity> ew = new EntityWrapper<KeyanrenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keyanrenyuan, "keyanrenyuan")); 
        return R.ok().put("data", keyanrenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeyanrenyuanEntity keyanrenyuan){
        EntityWrapper< KeyanrenyuanEntity> ew = new EntityWrapper< KeyanrenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keyanrenyuan, "keyanrenyuan")); 
		KeyanrenyuanView keyanrenyuanView =  keyanrenyuanService.selectView(ew);
		return R.ok("查询科研人员成功").put("data", keyanrenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeyanrenyuanEntity keyanrenyuan = keyanrenyuanService.selectById(id);
		keyanrenyuan = keyanrenyuanService.selectView(new EntityWrapper<KeyanrenyuanEntity>().eq("id", id));
        return R.ok().put("data", keyanrenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeyanrenyuanEntity keyanrenyuan = keyanrenyuanService.selectById(id);
		keyanrenyuan = keyanrenyuanService.selectView(new EntityWrapper<KeyanrenyuanEntity>().eq("id", id));
        return R.ok().put("data", keyanrenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanrenyuanEntity keyanrenyuan, HttpServletRequest request){
    	keyanrenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanrenyuan);
    	KeyanrenyuanEntity u = keyanrenyuanService.selectOne(new EntityWrapper<KeyanrenyuanEntity>().eq("keyanzhanghao", keyanrenyuan.getKeyanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		keyanrenyuan.setId(new Date().getTime());
        keyanrenyuanService.insert(keyanrenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KeyanrenyuanEntity keyanrenyuan, HttpServletRequest request){
    	keyanrenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanrenyuan);
    	KeyanrenyuanEntity u = keyanrenyuanService.selectOne(new EntityWrapper<KeyanrenyuanEntity>().eq("keyanzhanghao", keyanrenyuan.getKeyanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		keyanrenyuan.setId(new Date().getTime());
        keyanrenyuanService.insert(keyanrenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeyanrenyuanEntity keyanrenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keyanrenyuan);
        keyanrenyuanService.updateById(keyanrenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keyanrenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
