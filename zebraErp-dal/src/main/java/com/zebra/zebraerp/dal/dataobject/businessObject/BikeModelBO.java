package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.util.Date;

/**
 * 单车类型表业务BO
 * 
 * @ClassName: CBikeModelBO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public class BikeModelBO{

	/** 
	 * 主键 ( 主键 ) 
	 */
	private Long id;
	/** 
	 * 单车类型编号  
	 */
	private String bikeModelCode;
	/** 
	 * 单车类型名称  
	 */
	private String bikeModelName;
	/** 
	 * 所属加盟商编号  
	 */
	private String franchiserCode;
	/** 
	 * 所属加盟商名称  
	 */
	private String franchiserName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getBikeModelCode() {
		return bikeModelCode;
	}
	
	public void setBikeModelCode(String bikeModelCode) {
		this.bikeModelCode = bikeModelCode;
	}

	public String getBikeModelName() {
		return bikeModelName;
	}
	
	public void setBikeModelName(String bikeModelName) {
		this.bikeModelName = bikeModelName;
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