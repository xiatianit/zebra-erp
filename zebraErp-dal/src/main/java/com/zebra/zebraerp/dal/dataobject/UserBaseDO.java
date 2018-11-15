package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户基础表DO
 * 
 * @ClassName: UserBaseDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class UserBaseDO implements Serializable {

	/** 
	 * 用户主键 ( 主键 ) 
	 */
	private Long uid;
	/** 
	 * 注册手机  
	 */
	private String phone;
	/** 
	 * 登录密码(后期补充)  
	 */
	private String password;
	/** 
	 * 头像地址URL  
	 */
	private String headPortrait;
	/** 
	 * 用户昵称(默认为注册手机)  
	 */
	private String nickName;
	/** 
	 * 性别(1、男 2、女)  
	 */
	private Integer sex;
	/** 
	 * 年龄  
	 */
	private Integer age;
	/** 
	 * 职业  
	 */
	private String job;
	/** 
	 * 收入相框  
	 */
	private String income;
	/** 
	 * 实名认证状态(0，否；1，是；)  
	 */
	private Integer verifyStatus;
	/** 
	 * 真实姓名(用于实名认证)  
	 */
	private String actualName;
	/** 
	 * 身份证号码(用于实名认证)  
	 */
	private String idCardNo;
	/** 
	 * 用户状态(0，正常；1，非正常；...补充)  
	 */
	private Integer userStatus;
	/** 
	 * 注册时间  
	 */
	private Integer registerTime;
	/** 
	 * 修改时间(一般用于实名认证等资料补充)  
	 */
	private Integer modifyTime;
	/** 
	 * 信用分数  
	 */
	private Integer creditScore;
	/** 
	 * 邀请码  
	 */
	private String inviteCode;
	/** 
	 * 使用的邀请码  
	 */
	private String invitedCode;
}