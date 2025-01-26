package com.dao;

import com.entity.DingdanjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanjiluVO;
import com.entity.view.DingdanjiluView;


/**
 * 订单记录
 * 
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public interface DingdanjiluDao extends BaseMapper<DingdanjiluEntity> {
	
	List<DingdanjiluVO> selectListVO(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
	
	DingdanjiluVO selectVO(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
	
	List<DingdanjiluView> selectListView(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);

	List<DingdanjiluView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
	
	DingdanjiluView selectView(@Param("ew") Wrapper<DingdanjiluEntity> wrapper);
	

}
