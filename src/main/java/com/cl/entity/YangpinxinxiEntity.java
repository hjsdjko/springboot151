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
 * 样品信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("yangpinxinxi")
public class YangpinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YangpinxinxiEntity() {
		
	}
	
	public YangpinxinxiEntity(T t) {
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
	 * 样品编号
	 */
					
	private String yangpinbianhao;
	
	/**
	 * 样品名称
	 */
					
	private String yangpinmingcheng;
	
	/**
	 * 样品来源
	 */
					
	private String yangpinlaiyuan;
	
	/**
	 * 样品类型
	 */
					
	private String yangpinleixing;
	
	/**
	 * 采集时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date caijishijian;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	
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
	 * 设置：样品编号
	 */
	public void setYangpinbianhao(String yangpinbianhao) {
		this.yangpinbianhao = yangpinbianhao;
	}
	/**
	 * 获取：样品编号
	 */
	public String getYangpinbianhao() {
		return yangpinbianhao;
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
	 * 设置：样品来源
	 */
	public void setYangpinlaiyuan(String yangpinlaiyuan) {
		this.yangpinlaiyuan = yangpinlaiyuan;
	}
	/**
	 * 获取：样品来源
	 */
	public String getYangpinlaiyuan() {
		return yangpinlaiyuan;
	}
	/**
	 * 设置：样品类型
	 */
	public void setYangpinleixing(String yangpinleixing) {
		this.yangpinleixing = yangpinleixing;
	}
	/**
	 * 获取：样品类型
	 */
	public String getYangpinleixing() {
		return yangpinleixing;
	}
	/**
	 * 设置：采集时间
	 */
	public void setCaijishijian(Date caijishijian) {
		this.caijishijian = caijishijian;
	}
	/**
	 * 获取：采集时间
	 */
	public Date getCaijishijian() {
		return caijishijian;
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
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}

}
