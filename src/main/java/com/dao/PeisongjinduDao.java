package com.dao;

import com.entity.PeisongjinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeisongjinduVO;
import com.entity.view.PeisongjinduView;


/**
 * 配送进度
 * 
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface PeisongjinduDao extends BaseMapper<PeisongjinduEntity> {
	
	List<PeisongjinduVO> selectListVO(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
	
	PeisongjinduVO selectVO(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
	
	List<PeisongjinduView> selectListView(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);

	List<PeisongjinduView> selectListView(Pagination page,@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
	
	PeisongjinduView selectView(@Param("ew") Wrapper<PeisongjinduEntity> wrapper);
	

}
