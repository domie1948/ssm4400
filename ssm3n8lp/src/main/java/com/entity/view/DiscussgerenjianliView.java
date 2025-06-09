package com.entity.view;

import com.entity.DiscussgerenjianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 个人简历评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
@TableName("discussgerenjianli")
public class DiscussgerenjianliView  extends DiscussgerenjianliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgerenjianliView(){
	}
 
 	public DiscussgerenjianliView(DiscussgerenjianliEntity discussgerenjianliEntity){
 	try {
			BeanUtils.copyProperties(this, discussgerenjianliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
