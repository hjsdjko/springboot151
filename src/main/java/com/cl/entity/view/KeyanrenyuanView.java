package com.cl.entity.view;

import com.cl.entity.KeyanrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 科研人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 19:31:17
 */
@TableName("keyanrenyuan")
public class KeyanrenyuanView  extends KeyanrenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KeyanrenyuanView(){
	}
 
 	public KeyanrenyuanView(KeyanrenyuanEntity keyanrenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, keyanrenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
