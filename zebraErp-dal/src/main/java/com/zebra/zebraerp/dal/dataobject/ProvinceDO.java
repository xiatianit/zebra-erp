package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 省份信息表DO
 * 
 * @ClassName: ProvinceDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class ProvinceDO extends PageDO implements Serializable {

	/** 
	 * 省份代码 ( 主键 ) 
	 */
	private String provinceCode;
	/** 
	 * 省份名称  
	 */
	private String provinceName;
	/** 
	 * 省份简称  
	 */
	private String provinceAbbr;
}