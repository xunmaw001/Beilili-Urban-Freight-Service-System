package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanjiluView;


/**
 * 订单记录
 *
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface DingdanjiluService extends IService<DingdanjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanjiluVO> selectListVO(Wrapper<DingdanjiluEntity> wrapper);
   	
   	DingdanjiluVO selectVO(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
   	
   	List<DingdanjiluView> selectListView(Wrapper<DingdanjiluEntity> wrapper);
   	
   	DingdanjiluView selectView(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanjiluEntity> wrapper);
   	

}

