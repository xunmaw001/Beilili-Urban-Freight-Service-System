package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuochesijiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuochesijiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuochesijiView;


/**
 * 货车司机
 *
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface HuochesijiService extends IService<HuochesijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuochesijiVO> selectListVO(Wrapper<HuochesijiEntity> wrapper);
   	
   	HuochesijiVO selectVO(@Param("ew") Wrapper<HuochesijiEntity> wrapper);
   	
   	List<HuochesijiView> selectListView(Wrapper<HuochesijiEntity> wrapper);
   	
   	HuochesijiView selectView(@Param("ew") Wrapper<HuochesijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuochesijiEntity> wrapper);
   	

}

