package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 区域信息表DO
 * 
 * @ClassName: ZoneDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class ZoneDO extends PageDO implements Serializable {

	/** 
	 * 区域代码 ( 主键 ) 
	 */
	private String zoneCode;
	/** 
	 * 区域名称  
	 */
	private String zoneName;
	/** 
	 * 区域简称  
	 */
	private String zoneAbbr;
	/** 
	 * 中文全拼  
	 */
	private String zhSpell;
	/** 
	 * 所属省份ID  
	 */
	private String provinceCode;
	/** 
	 * 省份名称  
	 */
	private String provinceName;
	/** 
	 * 城市代码  
	 */
	private String cityCode;
	/** 
	 * 城市名称  
	 */
	private String cityName;
}