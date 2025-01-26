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


import com.dao.HuochesijiDao;
import com.entity.HuochesijiEntity;
import com.service.HuochesijiService;
import com.entity.vo.HuochesijiVO;
import com.entity.view.HuochesijiView;

@Service("huochesijiService")
public class HuochesijiServiceImpl extends ServiceImpl<HuochesijiDao, HuochesijiEntity> implements HuochesijiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuochesijiEntity> page = this.selectPage(
                new Query<HuochesijiEntity>(params).getPage(),
                new EntityWrapper<HuochesijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuochesijiEntity> wrapper) {
		  Page<HuochesijiView> page =new Query<HuochesijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuochesijiVO> selectListVO(Wrapper<HuochesijiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuochesijiVO selectVO(Wrapper<HuochesijiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuochesijiView> selectListView(Wrapper<HuochesijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuochesijiView selectView(Wrapper<HuochesijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
