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

import com.entity.HuochesijiEntity;
import com.entity.view.HuochesijiView;

import com.service.HuochesijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 货车司机
 * 后端接口
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@RestController
@RequestMapping("/huochesiji")
public class HuochesijiController {
    @Autowired
    private HuochesijiService huochesijiService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuochesijiEntity user = huochesijiService.selectOne(new EntityWrapper<HuochesijiEntity>().eq("sijixingming", username));
                if(user==null || !user.getMima().equals(MD5Util.md5(password))) {
                        return R.error("账号或密码不正确");
                }
		String token = tokenService.generateToken(user.getId(), username,"huochesiji",  "货车司机" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuochesijiEntity huochesiji){
    	//ValidatorUtils.validateEntity(huochesiji);
    	HuochesijiEntity user = huochesijiService.selectOne(new EntityWrapper<HuochesijiEntity>().eq("sijixingming", huochesiji.getSijixingming()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huochesiji.setId(uId);
                huochesiji.setMima(MD5Util.md5(huochesiji.getMima()));
        huochesijiService.insert(huochesiji);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuochesijiEntity user = huochesijiService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuochesijiEntity user = huochesijiService.selectOne(new EntityWrapper<HuochesijiEntity>().eq("sijixingming", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setMima(MD5Util.md5("123456"));
        huochesijiService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuochesijiEntity huochesiji, 
		HttpServletRequest request){

        EntityWrapper<HuochesijiEntity> ew = new EntityWrapper<HuochesijiEntity>();

    	PageUtils page = huochesijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochesiji), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuochesijiEntity huochesiji, 
		HttpServletRequest request){
        EntityWrapper<HuochesijiEntity> ew = new EntityWrapper<HuochesijiEntity>();

    	PageUtils page = huochesijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huochesiji), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuochesijiEntity huochesiji){
       	EntityWrapper<HuochesijiEntity> ew = new EntityWrapper<HuochesijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huochesiji, "huochesiji")); 
        return R.ok().put("data", huochesijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuochesijiEntity huochesiji){
        EntityWrapper< HuochesijiEntity> ew = new EntityWrapper< HuochesijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huochesiji, "huochesiji")); 
		HuochesijiView huochesijiView =  huochesijiService.selectView(ew);
		return R.ok("查询货车司机成功").put("data", huochesijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuochesijiEntity huochesiji = huochesijiService.selectById(id);
        return R.ok().put("data", huochesiji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuochesijiEntity huochesiji = huochesijiService.selectById(id);
        return R.ok().put("data", huochesiji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuochesijiEntity huochesiji, HttpServletRequest request){
    	huochesiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochesiji);
    	HuochesijiEntity user = huochesijiService.selectOne(new EntityWrapper<HuochesijiEntity>().eq("sijixingming", huochesiji.getSijixingming()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		huochesiji.setId(new Date().getTime());
                huochesiji.setMima(MD5Util.md5(huochesiji.getMima()));
        huochesijiService.insert(huochesiji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuochesijiEntity huochesiji, HttpServletRequest request){
    	huochesiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huochesiji);
    	HuochesijiEntity user = huochesijiService.selectOne(new EntityWrapper<HuochesijiEntity>().eq("sijixingming", huochesiji.getSijixingming()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		huochesiji.setId(new Date().getTime());
                huochesiji.setMima(MD5Util.md5(huochesiji.getMima()));
        huochesijiService.insert(huochesiji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuochesijiEntity huochesiji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huochesiji);
	HuochesijiEntity huochesijiEntity = huochesijiService.selectById(huochesiji.getId());
        if(StringUtils.isNotBlank(huochesiji.getMima()) && !huochesiji.getMima().equals(huochesijiEntity.getMima())) {
                huochesiji.setMima(MD5Util.md5(huochesiji.getMima()));
        }
        huochesijiService.updateById(huochesiji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huochesijiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuochesijiEntity> wrapper = new EntityWrapper<HuochesijiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = huochesijiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
