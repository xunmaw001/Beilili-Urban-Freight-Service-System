package com.entity.vo;

import com.entity.DingdanpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 订单评价
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-07-31 10:16:04
 */
public class DingdanpingjiaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 货物名称
	 */
	
	private String huowumingcheng;
		
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
	 * 司机姓名
	 */
	
	private String sijixingming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 订单评分
	 */
	
	private String dingdanpingfen;
		
	/**
	 * 评价内容
	 */
	
	private String pingjianeirong;
		
	/**
	 * 留言建议
	 */
	
	private String liuyanjianyi;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：订单评分
	 */
	 
	public void setDingdanpingfen(String dingdanpingfen) {
		this.dingdanpingfen = dingdanpingfen;
	}
	
	/**
	 * 获取：订单评分
	 */
	public String getDingdanpingfen() {
		return dingdanpingfen;
	}
				
	
	/**
	 * 设置：评价内容
	 */
	 
	public void setPingjianeirong(String pingjianeirong) {
		this.pingjianeirong = pingjianeirong;
	}
	
	/**
	 * 获取：评价内容
	 */
	public String getPingjianeirong() {
		return pingjianeirong;
	}
				
	
	/**
	 * 设置：留言建议
	 */
	 
	public void setLiuyanjianyi(String liuyanjianyi) {
		this.liuyanjianyi = liuyanjianyi;
	}
	
	/**
	 * 获取：留言建议
	 */
	public String getLiuyanjianyi() {
		return liuyanjianyi;
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
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
