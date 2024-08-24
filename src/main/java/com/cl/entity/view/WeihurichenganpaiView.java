package com.cl.entity.view;

import com.cl.entity.WeihurichenganpaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 维护日程安排
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("weihurichenganpai")
public class WeihurichenganpaiView  extends WeihurichenganpaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeihurichenganpaiView(){
	}
 
 	public WeihurichenganpaiView(WeihurichenganpaiEntity weihurichenganpaiEntity){
 	try {
			BeanUtils.copyProperties(this, weihurichenganpaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
