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
 * 维护人员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("weihurenyuan")
public class WeihurenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WeihurenyuanEntity() {
		
	}
	
	public WeihurenyuanEntity(T t) {
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
	 * 维护账号
	 */
					
	private String weihuzhanghao;
	
	/**
	 * 维护密码
	 */
					
	private String weihumima;
	
	/**
	 * 维护人姓名
	 */
					
	private String weihurenxingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 手机号码
	 */
					
	private String shoujihaoma;
	
	
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
	 * 设置：维护账号
	 */
	public void setWeihuzhanghao(String weihuzhanghao) {
		this.weihuzhanghao = weihuzhanghao;
	}
	/**
	 * 获取：维护账号
	 */
	public String getWeihuzhanghao() {
		return weihuzhanghao;
	}
	/**
	 * 设置：维护密码
	 */
	public void setWeihumima(String weihumima) {
		this.weihumima = weihumima;
	}
	/**
	 * 获取：维护密码
	 */
	public String getWeihumima() {
		return weihumima;
	}
	/**
	 * 设置：维护人姓名
	 */
	public void setWeihurenxingming(String weihurenxingming) {
		this.weihurenxingming = weihurenxingming;
	}
	/**
	 * 获取：维护人姓名
	 */
	public String getWeihurenxingming() {
		return weihurenxingming;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：手机号码
	 */
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}

}
