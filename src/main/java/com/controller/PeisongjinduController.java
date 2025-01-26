package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PeisongjinduEntity;
import com.entity.view.PeisongjinduView;

import com.service.PeisongjinduService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配送进度
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@RestController
@RequestMapping("/peisongjindu")
public class PeisongjinduController {
    @Autowired
    private PeisongjinduService peisongjinduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeisongjinduEntity peisongjindu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yunshushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yunshushijianend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huochesiji")) {
			peisongjindu.setSijixingming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			peisongjindu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PeisongjinduEntity> ew = new EntityWrapper<PeisongjinduEntity>();
                if(yunshushijianstart!=null) ew.ge("yunshushijian", yunshushijianstart);
                if(yunshushijianend!=null) ew.le("yunshushijian", yunshushijianend);

    	PageUtils page = peisongjinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongjindu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeisongjinduEntity peisongjindu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yunshushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date yunshushijianend,
		HttpServletRequest request){
        EntityWrapper<PeisongjinduEntity> ew = new EntityWrapper<PeisongjinduEntity>();
                if(yunshushijianstart!=null) ew.ge("yunshushijian", yunshushijianstart);
                if(yunshushijianend!=null) ew.le("yunshushijian", yunshushijianend);

    	PageUtils page = peisongjinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongjindu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeisongjinduEntity peisongjindu){
       	EntityWrapper<PeisongjinduEntity> ew = new EntityWrapper<PeisongjinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peisongjindu, "peisongjindu")); 
        return R.ok().put("data", peisongjinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeisongjinduEntity peisongjindu){
        EntityWrapper< PeisongjinduEntity> ew = new EntityWrapper< PeisongjinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peisongjindu, "peisongjindu")); 
		PeisongjinduView peisongjinduView =  peisongjinduService.selectView(ew);
		return R.ok("查询配送进度成功").put("data", peisongjinduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeisongjinduEntity peisongjindu = peisongjinduService.selectById(id);
        return R.ok().put("data", peisongjindu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeisongjinduEntity peisongjindu = peisongjinduService.selectById(id);
        return R.ok().put("data", peisongjindu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeisongjinduEntity peisongjindu, HttpServletRequest request){
    	peisongjindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peisongjindu);

        peisongjinduService.insert(peisongjindu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeisongjinduEntity peisongjindu, HttpServletRequest request){
    	peisongjindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peisongjindu);

        peisongjinduService.insert(peisongjindu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeisongjinduEntity peisongjindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongjindu);
        peisongjinduService.updateById(peisongjindu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peisongjinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PeisongjinduEntity> wrapper = new EntityWrapper<PeisongjinduEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huochesiji")) {
			wrapper.eq("sijixingming", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = peisongjinduService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
