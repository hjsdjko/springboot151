package com.cl.entity.view;

import com.cl.entity.HaocaikucunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 耗材库存
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("haocaikucun")
public class HaocaikucunView  extends HaocaikucunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HaocaikucunView(){
	}
 
 	public HaocaikucunView(HaocaikucunEntity haocaikucunEntity){
 	try {
			BeanUtils.copyProperties(this, haocaikucunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
