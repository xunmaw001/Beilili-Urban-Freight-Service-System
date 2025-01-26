package com.entity.view;

import com.entity.DingdanjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 订单记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@TableName("dingdanjilu")
public class DingdanjiluView  extends DingdanjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DingdanjiluView(){
	}
 
 	public DingdanjiluView(DingdanjiluEntity dingdanjiluEntity){
 	try {
			BeanUtils.copyProperties(this, dingdanjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
