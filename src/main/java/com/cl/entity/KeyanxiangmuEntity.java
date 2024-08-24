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
 * 科研项目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("keyanxiangmu")
public class KeyanxiangmuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KeyanxiangmuEntity() {
		
	}
	
	public KeyanxiangmuEntity(T t) {
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
	 * 项目编号
	 */
					
	private String xiangmubianhao;
	
	/**
	 * 项目名称
	 */
					
	private String xiangmumingcheng;
	
	/**
	 * 项目负责人
	 */
					
	private String xiangmufuzeren;
	
	/**
	 * 项目成员
	 */
					
	private String xiangmuchengyuan;
	
	/**
	 * 项目开始时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date xiangmukaishishijian;
	
	/**
	 * 项目结束时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date xiangmujieshushijian;
	
	/**
	 * 研究内容
	 */
					
	private String yanjiuneirong;
	
	/**
	 * 预算
	 */
					
	private Double yusuan;
	
	/**
	 * 成果形式
	 */
					
	private String chengguoxingshi;
	
	
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
	 * 设置：项目编号
	 */
	public void setXiangmubianhao(String xiangmubianhao) {
		this.xiangmubianhao = xiangmubianhao;
	}
	/**
	 * 获取：项目编号
	 */
	public String getXiangmubianhao() {
		return xiangmubianhao;
	}
	/**
	 * 设置：项目名称
	 */
	public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
	}
	/**
	 * 获取：项目名称
	 */
	public String getXiangmumingcheng() {
		return xiangmumingcheng;
	}
	/**
	 * 设置：项目负责人
	 */
	public void setXiangmufuzeren(String xiangmufuzeren) {
		this.xiangmufuzeren = xiangmufuzeren;
	}
	/**
	 * 获取：项目负责人
	 */
	public String getXiangmufuzeren() {
		return xiangmufuzeren;
	}
	/**
	 * 设置：项目成员
	 */
	public void setXiangmuchengyuan(String xiangmuchengyuan) {
		this.xiangmuchengyuan = xiangmuchengyuan;
	}
	/**
	 * 获取：项目成员
	 */
	public String getXiangmuchengyuan() {
		return xiangmuchengyuan;
	}
	/**
	 * 设置：项目开始时间
	 */
	public void setXiangmukaishishijian(Date xiangmukaishishijian) {
		this.xiangmukaishishijian = xiangmukaishishijian;
	}
	/**
	 * 获取：项目开始时间
	 */
	public Date getXiangmukaishishijian() {
		return xiangmukaishishijian;
	}
	/**
	 * 设置：项目结束时间
	 */
	public void setXiangmujieshushijian(Date xiangmujieshushijian) {
		this.xiangmujieshushijian = xiangmujieshushijian;
	}
	/**
	 * 获取：项目结束时间
	 */
	public Date getXiangmujieshushijian() {
		return xiangmujieshushijian;
	}
	/**
	 * 设置：研究内容
	 */
	public void setYanjiuneirong(String yanjiuneirong) {
		this.yanjiuneirong = yanjiuneirong;
	}
	/**
	 * 获取：研究内容
	 */
	public String getYanjiuneirong() {
		return yanjiuneirong;
	}
	/**
	 * 设置：预算
	 */
	public void setYusuan(Double yusuan) {
		this.yusuan = yusuan;
	}
	/**
	 * 获取：预算
	 */
	public Double getYusuan() {
		return yusuan;
	}
	/**
	 * 设置：成果形式
	 */
	public void setChengguoxingshi(String chengguoxingshi) {
		this.chengguoxingshi = chengguoxingshi;
	}
	/**
	 * 获取：成果形式
	 */
	public String getChengguoxingshi() {
		return chengguoxingshi;
	}

}
