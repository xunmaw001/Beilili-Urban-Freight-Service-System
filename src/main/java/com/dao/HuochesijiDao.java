package com.dao;

import com.entity.HuochesijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuochesijiVO;
import com.entity.view.HuochesijiView;


/**
 * 货车司机
 * 
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface HuochesijiDao extends BaseMapper<HuochesijiEntity> {
	
	List<HuochesijiVO> selectListVO(@Param("ew") Wrapper<HuochesijiEntity> wrapper);
	
	HuochesijiVO selectVO(@Param("ew") Wrapper<HuochesijiEntity> wrapper);
	
	List<HuochesijiView> selectListView(@Param("ew") Wrapper<HuochesijiEntity> wrapper);

	List<HuochesijiView> selectListView(Pagination page,@Param("ew") Wrapper<HuochesijiEntity> wrapper);
	
	HuochesijiView selectView(@Param("ew") Wrapper<HuochesijiEntity> wrapper);
	

}
