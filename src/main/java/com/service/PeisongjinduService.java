package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeisongjinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeisongjinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeisongjinduView;


/**
 * 配送进度
 *
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface PeisongjinduService extends IService<PeisongjinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeisongjinduVO> selectListVO(Wrapper<PeisongjinduEntity> wrapper);
   	
   	PeisongjinduVO selectVO(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
   	
   	List<PeisongjinduView> selectListView(Wrapper<PeisongjinduEntity> wrapper);
   	
   	PeisongjinduView selectView(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeisongjinduEntity> wrapper);
   	

}

