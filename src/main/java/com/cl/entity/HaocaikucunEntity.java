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
 * 耗材库存
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("haocaikucun")
public class HaocaikucunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HaocaikucunEntity() {
		
	}
	
	public HaocaikucunEntity(T t) {
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
	 * 材料编号
	 */
					
	private String cailiaobianhao;
	
	/**
	 * 材料名称
	 */
					
	private String cailiaomingcheng;
	
	/**
	 * 材料规格
	 */
					
	private String cailiaoguige;
	
	/**
	 * 生产厂家
	 */
					
	private String shengchanchangjia;
	
	/**
	 * 购买日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date goumairiqi;
	
	/**
	 * 保质期
	 */
					
	private String baozhiqi;
	
	/**
	 * 材料用途
	 */
					
	private String cailiaoyongtu;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 使用记录
	 */
					
	private String shiyongjilu;
	
	
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
	 * 设置：材料编号
	 */
	public void setCailiaobianhao(String cailiaobianhao) {
		this.cailiaobianhao = cailiaobianhao;
	}
	/**
	 * 获取：材料编号
	 */
	public String getCailiaobianhao() {
		return cailiaobianhao;
	}
	/**
	 * 设置：材料名称
	 */
	public void setCailiaomingcheng(String cailiaomingcheng) {
		this.cailiaomingcheng = cailiaomingcheng;
	}
	/**
	 * 获取：材料名称
	 */
	public String getCailiaomingcheng() {
		return cailiaomingcheng;
	}
	/**
	 * 设置：材料规格
	 */
	public void setCailiaoguige(String cailiaoguige) {
		this.cailiaoguige = cailiaoguige;
	}
	/**
	 * 获取：材料规格
	 */
	public String getCailiaoguige() {
		return cailiaoguige;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setShengchanchangjia(String shengchanchangjia) {
		this.shengchanchangjia = shengchanchangjia;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getShengchanchangjia() {
		return shengchanchangjia;
	}
	/**
	 * 设置：购买日期
	 */
	public void setGoumairiqi(Date goumairiqi) {
		this.goumairiqi = goumairiqi;
	}
	/**
	 * 获取：购买日期
	 */
	public Date getGoumairiqi() {
		return goumairiqi;
	}
	/**
	 * 设置：保质期
	 */
	public void setBaozhiqi(String baozhiqi) {
		this.baozhiqi = baozhiqi;
	}
	/**
	 * 获取：保质期
	 */
	public String getBaozhiqi() {
		return baozhiqi;
	}
	/**
	 * 设置：材料用途
	 */
	public void setCailiaoyongtu(String cailiaoyongtu) {
		this.cailiaoyongtu = cailiaoyongtu;
	}
	/**
	 * 获取：材料用途
	 */
	public String getCailiaoyongtu() {
		return cailiaoyongtu;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：使用记录
	 */
	public void setShiyongjilu(String shiyongjilu) {
		this.shiyongjilu = shiyongjilu;
	}
	/**
	 * 获取：使用记录
	 */
	public String getShiyongjilu() {
		return shiyongjilu;
	}

}
