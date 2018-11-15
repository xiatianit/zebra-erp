package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 单车类型表DO
 * 
 * @ClassName: BikeModelDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class BikeModelDO extends PageDO implements Serializable {

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
}