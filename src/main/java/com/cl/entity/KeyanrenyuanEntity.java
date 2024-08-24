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
 * 科研人员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("keyanrenyuan")
public class KeyanrenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KeyanrenyuanEntity() {
		
	}
	
	public KeyanrenyuanEntity(T t) {
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
	 * 科研账号
	 */
					
	private String keyanzhanghao;
	
	/**
	 * 科研密码
	 */
					
	private String keyanmima;
	
	/**
	 * 科研人员姓名
	 */
					
	private String keyanrenyuanxingming;
	
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
	 * 设置：科研密码
	 */
	public void setKeyanmima(String keyanmima) {
		this.keyanmima = keyanmima;
	}
	/**
	 * 获取：科研密码
	 */
	public String getKeyanmima() {
		return keyanmima;
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
