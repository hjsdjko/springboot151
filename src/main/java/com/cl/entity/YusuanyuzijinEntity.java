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
 * 预算与资金
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("yusuanyuzijin")
public class YusuanyuzijinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YusuanyuzijinEntity() {
		
	}
	
	public YusuanyuzijinEntity(T t) {
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
	 * 收支类别
	 */
					
	private String shouzhileibie;
	
	/**
	 * 金额
	 */
					
	private Double jine;
	
	/**
	 * 日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date riqi;
	
	/**
	 * 资金去向
	 */
					
	private String zijinquxiang;
	
	/**
	 * 项目名称
	 */
					
	private String xiangmumingcheng;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 预算
	 */
					
	private Double yusuan;
	
	
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
	 * 设置：收支类别
	 */
	public void setShouzhileibie(String shouzhileibie) {
		this.shouzhileibie = shouzhileibie;
	}
	/**
	 * 获取：收支类别
	 */
	public String getShouzhileibie() {
		return shouzhileibie;
	}
	/**
	 * 设置：金额
	 */
	public void setJine(Double jine) {
		this.jine = jine;
	}
	/**
	 * 获取：金额
	 */
	public Double getJine() {
		return jine;
	}
	/**
	 * 设置：日期
	 */
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
	/**
	 * 设置：资金去向
	 */
	public void setZijinquxiang(String zijinquxiang) {
		this.zijinquxiang = zijinquxiang;
	}
	/**
	 * 获取：资金去向
	 */
	public String getZijinquxiang() {
		return zijinquxiang;
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
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
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

}
