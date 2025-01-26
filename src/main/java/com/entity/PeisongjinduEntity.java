package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 配送进度
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
@TableName("peisongjindu")
public class PeisongjinduEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeisongjinduEntity() {
		
	}
	
	public PeisongjinduEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 货物名称
	 */
					
	private String huowumingcheng;
	
	/**
	 * 货物重量
	 */
					
	private String huowuzhongliang;
	
	/**
	 * 运输金额
	 */
					
	private Integer yunshujine;
	
	/**
	 * 收件人
	 */
					
	private String shoujianren;
	
	/**
	 * 收件电话
	 */
					
	private String shoujiandianhua;
	
	/**
	 * 收件地址
	 */
					
	private String shoujiandizhi;
	
	/**
	 * 订单备注
	 */
					
	private String dingdanbeizhu;
	
	/**
	 * 司机姓名
	 */
					
	private String sijixingming;
	
	/**
	 * 车牌号码
	 */
					
	private String chepaihaoma;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 运输进度
	 */
					
	private String yunshujindu;
	
	/**
	 * 信息备注
	 */
					
	private String xinxibeizhu;
	
	/**
	 * 订单评价
	 */
					
	private String dingdanpingjia;
	
	/**
	 * 运输时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yunshushijian;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：货物名称
	 */
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	/**
	 * 获取：货物名称
	 */
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	/**
	 * 设置：货物重量
	 */
	public void setHuowuzhongliang(String huowuzhongliang) {
		this.huowuzhongliang = huowuzhongliang;
	}
	/**
	 * 获取：货物重量
	 */
	public String getHuowuzhongliang() {
		return huowuzhongliang;
	}
	/**
	 * 设置：运输金额
	 */
	public void setYunshujine(Integer yunshujine) {
		this.yunshujine = yunshujine;
	}
	/**
	 * 获取：运输金额
	 */
	public Integer getYunshujine() {
		return yunshujine;
	}
	/**
	 * 设置：收件人
	 */
	public void setShoujianren(String shoujianren) {
		this.shoujianren = shoujianren;
	}
	/**
	 * 获取：收件人
	 */
	public String getShoujianren() {
		return shoujianren;
	}
	/**
	 * 设置：收件电话
	 */
	public void setShoujiandianhua(String shoujiandianhua) {
		this.shoujiandianhua = shoujiandianhua;
	}
	/**
	 * 获取：收件电话
	 */
	public String getShoujiandianhua() {
		return shoujiandianhua;
	}
	/**
	 * 设置：收件地址
	 */
	public void setShoujiandizhi(String shoujiandizhi) {
		this.shoujiandizhi = shoujiandizhi;
	}
	/**
	 * 获取：收件地址
	 */
	public String getShoujiandizhi() {
		return shoujiandizhi;
	}
	/**
	 * 设置：订单备注
	 */
	public void setDingdanbeizhu(String dingdanbeizhu) {
		this.dingdanbeizhu = dingdanbeizhu;
	}
	/**
	 * 获取：订单备注
	 */
	public String getDingdanbeizhu() {
		return dingdanbeizhu;
	}
	/**
	 * 设置：司机姓名
	 */
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
	/**
	 * 设置：车牌号码
	 */
	public void setChepaihaoma(String chepaihaoma) {
		this.chepaihaoma = chepaihaoma;
	}
	/**
	 * 获取：车牌号码
	 */
	public String getChepaihaoma() {
		return chepaihaoma;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：运输进度
	 */
	public void setYunshujindu(String yunshujindu) {
		this.yunshujindu = yunshujindu;
	}
	/**
	 * 获取：运输进度
	 */
	public String getYunshujindu() {
		return yunshujindu;
	}
	/**
	 * 设置：信息备注
	 */
	public void setXinxibeizhu(String xinxibeizhu) {
		this.xinxibeizhu = xinxibeizhu;
	}
	/**
	 * 获取：信息备注
	 */
	public String getXinxibeizhu() {
		return xinxibeizhu;
	}
	/**
	 * 设置：订单评价
	 */
	public void setDingdanpingjia(String dingdanpingjia) {
		this.dingdanpingjia = dingdanpingjia;
	}
	/**
	 * 获取：订单评价
	 */
	public String getDingdanpingjia() {
		return dingdanpingjia;
	}
	/**
	 * 设置：运输时间
	 */
	public void setYunshushijian(Date yunshushijian) {
		this.yunshushijian = yunshushijian;
	}
	/**
	 * 获取：运输时间
	 */
	public Date getYunshushijian() {
		return yunshushijian;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
