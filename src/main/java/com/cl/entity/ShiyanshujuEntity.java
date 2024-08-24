package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 实验数据
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("shiyanshuju")
public class ShiyanshujuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShiyanshujuEntity() {
		
	}
	
	public ShiyanshujuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 实验名称
	 */
					
	private String shiyanmingcheng;
	
	/**
	 * 实验日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shiyanriqi;
	
	/**
	 * 科研账号
	 */
					
	private String keyanzhanghao;
	
	/**
	 * 科研人员姓名
	 */
					
	private String keyanrenyuanxingming;
	
	/**
	 * 数据类型
	 */
					
	private String shujuleixing;
	
	/**
	 * 数据单位
	 */
					
	private String shujudanwei;
	
	/**
	 * 样品名称
	 */
					
	private String yangpinmingcheng;
	
	/**
	 * 原始数据
	 */
					
	private String yuanshishuju;
	
	/**
	 * 处理数据
	 */
					
	private String chulishuju;
	
	/**
	 * 误差范围
	 */
					
	private String wuchafanwei;
	
	/**
	 * 数据注释
	 */
					
	private String shujuzhushi;
	
	/**
	 * 实验条件
	 */
					
	private String shiyantiaojian;
	
	/**
	 * 结论
	 */
					
	private String jielun;
	
	/**
	 * 实验状态
	 */
					
	private String shiyanzhuangtai;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：实验名称
	 */
	public void setShiyanmingcheng(String shiyanmingcheng) {
		this.shiyanmingcheng = shiyanmingcheng;
	}
	/**
	 * 获取：实验名称
	 */
	public String getShiyanmingcheng() {
		return shiyanmingcheng;
	}
	/**
	 * 设置：实验日期
	 */
	public void setShiyanriqi(Date shiyanriqi) {
		this.shiyanriqi = shiyanriqi;
	}
	/**
	 * 获取：实验日期
	 */
	public Date getShiyanriqi() {
		return shiyanriqi;
	}
	/**
	 * 设置：科研账号
	 */
	public void setKeyanzhanghao(String keyanzhanghao) {
		this.keyanzhanghao = keyanzhanghao;
	}
	/**
	 * 获取：科研账号
	 */
	public String getKeyanzhanghao() {
		return keyanzhanghao;
	}
	/**
	 * 设置：科研人员姓名
	 */
	public void setKeyanrenyuanxingming(String keyanrenyuanxingming) {
		this.keyanrenyuanxingming = keyanrenyuanxingming;
	}
	/**
	 * 获取：科研人员姓名
	 */
	public String getKeyanrenyuanxingming() {
		return keyanrenyuanxingming;
	}
	/**
	 * 设置：数据类型
	 */
	public void setShujuleixing(String shujuleixing) {
		this.shujuleixing = shujuleixing;
	}
	/**
	 * 获取：数据类型
	 */
	public String getShujuleixing() {
		return shujuleixing;
	}
	/**
	 * 设置：数据单位
	 */
	public void setShujudanwei(String shujudanwei) {
		this.shujudanwei = shujudanwei;
	}
	/**
	 * 获取：数据单位
	 */
	public String getShujudanwei() {
		return shujudanwei;
	}
	/**
	 * 设置：样品名称
	 */
	public void setYangpinmingcheng(String yangpinmingcheng) {
		this.yangpinmingcheng = yangpinmingcheng;
	}
	/**
	 * 获取：样品名称
	 */
	public String getYangpinmingcheng() {
		return yangpinmingcheng;
	}
	/**
	 * 设置：原始数据
	 */
	public void setYuanshishuju(String yuanshishuju) {
		this.yuanshishuju = yuanshishuju;
	}
	/**
	 * 获取：原始数据
	 */
	public String getYuanshishuju() {
		return yuanshishuju;
	}
	/**
	 * 设置：处理数据
	 */
	public void setChulishuju(String chulishuju) {
		this.chulishuju = chulishuju;
	}
	/**
	 * 获取：处理数据
	 */
	public String getChulishuju() {
		return chulishuju;
	}
	/**
	 * 设置：误差范围
	 */
	public void setWuchafanwei(String wuchafanwei) {
		this.wuchafanwei = wuchafanwei;
	}
	/**
	 * 获取：误差范围
	 */
	public String getWuchafanwei() {
		return wuchafanwei;
	}
	/**
	 * 设置：数据注释
	 */
	public void setShujuzhushi(String shujuzhushi) {
		this.shujuzhushi = shujuzhushi;
	}
	/**
	 * 获取：数据注释
	 */
	public String getShujuzhushi() {
		return shujuzhushi;
	}
	/**
	 * 设置：实验条件
	 */
	public void setShiyantiaojian(String shiyantiaojian) {
		this.shiyantiaojian = shiyantiaojian;
	}
	/**
	 * 获取：实验条件
	 */
	public String getShiyantiaojian() {
		return shiyantiaojian;
	}
	/**
	 * 设置：结论
	 */
	public void setJielun(String jielun) {
		this.jielun = jielun;
	}
	/**
	 * 获取：结论
	 */
	public String getJielun() {
		return jielun;
	}
	/**
	 * 设置：实验状态
	 */
	public void setShiyanzhuangtai(String shiyanzhuangtai) {
		this.shiyanzhuangtai = shiyanzhuangtai;
	}
	/**
	 * 获取：实验状态
	 */
	public String getShiyanzhuangtai() {
		return shiyanzhuangtai;
	}

}
