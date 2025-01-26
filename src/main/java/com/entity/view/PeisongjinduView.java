package com.entity.view;

import com.entity.PeisongjinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 配送进度
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@TableName("peisongjindu")
public class PeisongjinduView  extends PeisongjinduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeisongjinduView(){
	}
 
 	public PeisongjinduView(PeisongjinduEntity peisongjinduEntity){
 	try {
			BeanUtils.copyProperties(this, peisongjinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
