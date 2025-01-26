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

import com.entity.DingdanjiluEntity;
import com.entity.view.DingdanjiluView;

import com.service.DingdanjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单记录
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@RestController
@RequestMapping("/dingdanjilu")
public class DingdanjiluController {
    @Autowired
    private DingdanjiluService dingdanjiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanjiluEntity dingdanjilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiadanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiadanshijianend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huochesiji")) {
			dingdanjilu.setSijixingming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			dingdanjilu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanjiluEntity> ew = new EntityWrapper<DingdanjiluEntity>();
                if(xiadanshijianstart!=null) ew.ge("xiadanshijian", xiadanshijianstart);
                if(xiadanshijianend!=null) ew.le("xiadanshijian", xiadanshijianend);

    	PageUtils page = dingdanjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjilu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanjiluEntity dingdanjilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiadanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xiadanshijianend,
		HttpServletRequest request){
        EntityWrapper<DingdanjiluEntity> ew = new EntityWrapper<DingdanjiluEntity>();
                if(xiadanshijianstart!=null) ew.ge("xiadanshijian", xiadanshijianstart);
                if(xiadanshijianend!=null) ew.le("xiadanshijian", xiadanshijianend);

    	PageUtils page = dingdanjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjilu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanjiluEntity dingdanjilu){
       	EntityWrapper<DingdanjiluEntity> ew = new EntityWrapper<DingdanjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanjilu, "dingdanjilu")); 
        return R.ok().put("data", dingdanjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanjiluEntity dingdanjilu){
        EntityWrapper< DingdanjiluEntity> ew = new EntityWrapper< DingdanjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanjilu, "dingdanjilu")); 
		DingdanjiluView dingdanjiluView =  dingdanjiluService.selectView(ew);
		return R.ok("查询订单记录成功").put("data", dingdanjiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanjiluEntity dingdanjilu = dingdanjiluService.selectById(id);
        return R.ok().put("data", dingdanjilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanjiluEntity dingdanjilu = dingdanjiluService.selectById(id);
        return R.ok().put("data", dingdanjilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanjiluEntity dingdanjilu, HttpServletRequest request){
    	dingdanjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanjilu);

        dingdanjiluService.insert(dingdanjilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanjiluEntity dingdanjilu, HttpServletRequest request){
    	dingdanjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanjilu);

        dingdanjiluService.insert(dingdanjilu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanjiluEntity dingdanjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanjilu);
        dingdanjiluService.updateById(dingdanjilu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanjiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DingdanjiluEntity> wrapper = new EntityWrapper<DingdanjiluEntity>();
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

		int count = dingdanjiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
