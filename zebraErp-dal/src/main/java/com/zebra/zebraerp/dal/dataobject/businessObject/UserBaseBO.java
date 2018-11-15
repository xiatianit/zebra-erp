package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.util.Date;

/**
 * 用户基础表业务BO
 * 
 * @ClassName: CUserBaseBO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public class UserBaseBO{

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
	
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}
	
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

	public String getIncome() {
		return income;
	}
	
	public void setIncome(String income) {
		this.income = income;
	}

	public Integer getVerifyStatus() {
		return verifyStatus;
	}
	
	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getActualName() {
		return actualName;
	}
	
	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}
	
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Integer getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(Integer registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCreditScore() {
		return creditScore;
	}
	
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public String getInviteCode() {
		return inviteCode;
	}
	
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getInvitedCode() {
		return invitedCode;
	}
	
	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}

	/* -------------------- 非DB字段 -------------------- */
}