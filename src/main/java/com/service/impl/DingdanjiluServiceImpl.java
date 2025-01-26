package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DingdanjiluDao;
import com.entity.DingdanjiluEntity;
import com.service.DingdanjiluService;
import com.entity.vo.DingdanjiluVO;
import com.entity.view.DingdanjiluView;

@Service("dingdanjiluService")
public class DingdanjiluServiceImpl extends ServiceImpl<DingdanjiluDao, DingdanjiluEntity> implements DingdanjiluService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanjiluEntity> page = this.selectPage(
                new Query<DingdanjiluEntity>(params).getPage(),
                new EntityWrapper<DingdanjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanjiluEntity> wrapper) {
		  Page<DingdanjiluView> page =new Query<DingdanjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingdanjiluVO> selectListVO(Wrapper<DingdanjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanjiluVO selectVO(Wrapper<DingdanjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanjiluView> selectListView(Wrapper<DingdanjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanjiluView selectView(Wrapper<DingdanjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
