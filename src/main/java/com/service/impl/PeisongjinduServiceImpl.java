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


import com.dao.PeisongjinduDao;
import com.entity.PeisongjinduEntity;
import com.service.PeisongjinduService;
import com.entity.vo.PeisongjinduVO;
import com.entity.view.PeisongjinduView;

@Service("peisongjinduService")
public class PeisongjinduServiceImpl extends ServiceImpl<PeisongjinduDao, PeisongjinduEntity> implements PeisongjinduService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeisongjinduEntity> page = this.selectPage(
                new Query<PeisongjinduEntity>(params).getPage(),
                new EntityWrapper<PeisongjinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeisongjinduEntity> wrapper) {
		  Page<PeisongjinduView> page =new Query<PeisongjinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeisongjinduVO> selectListVO(Wrapper<PeisongjinduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeisongjinduVO selectVO(Wrapper<PeisongjinduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeisongjinduView> selectListView(Wrapper<PeisongjinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeisongjinduView selectView(Wrapper<PeisongjinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
