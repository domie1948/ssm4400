package com.entity.view;

import com.entity.PingjiaqiyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评价企业
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
@TableName("pingjiaqiye")
public class PingjiaqiyeView  extends PingjiaqiyeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingjiaqiyeView(){
	}
 
 	public PingjiaqiyeView(PingjiaqiyeEntity pingjiaqiyeEntity){
 	try {
			BeanUtils.copyProperties(this, pingjiaqiyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
