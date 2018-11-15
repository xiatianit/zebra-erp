package com.zebra.zebraerp.api.paramobject;

import java.util.Date;

/**
 * erp管理员表业务BO
 * 
 * @ClassName: CErpManagerBO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public class ErpManagerPO{

	/** 
	 * 管理员姓名  
	 */
	private String managerName;
	/** 
	 * 管理员昵称  
	 */
	private String nickName;
	/** 
	 * erp管理员角色类型(1-官方;  2-加盟商)  
	 */
	private Integer managerRoleType;
	/** 
	 * 手机号码  
	 */
	private String phone;
	/** 
	 * 密码  
	 */
	private String password;
	/** 
	 * 注册时间  
	 */
	private Date registerTime;
	/** 
	 * 所属加盟商编号  
	 */
	private String franchiserCode;
	/** 
	 * 所属加盟商名称  
	 */
	private String franchiserName;


	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getManagerRoleType() {
		return managerRoleType;
	}
	
	public void setManagerRoleType(Integer managerRoleType) {
		this.managerRoleType = managerRoleType;
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

	public Date getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getFranchiserCode() {
		return franchiserCode;
	}
	
	public void setFranchiserCode(String franchiserCode) {
		this.franchiserCode = franchiserCode;
	}

	public String getFranchiserName() {
		return franchiserName;
	}
	
	public void setFranchiserName(String franchiserName) {
		this.franchiserName = franchiserName;
	}

	/* -------------------- 非DB字段 -------------------- */
}