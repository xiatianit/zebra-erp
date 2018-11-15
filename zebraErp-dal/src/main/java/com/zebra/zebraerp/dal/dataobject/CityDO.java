package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 城市信息表DO
 * 
 * @ClassName: CityDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class CityDO extends PageDO implements Serializable {

	/** 
	 * 城市代码 ( 主键 ) 
	 */
	private String cityCode;
	/** 
	 * 城市名称  
	 */
	private String cityName;
	/** 
	 * 城市简称  
	 */
	private String cityAbbr;
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
	 * 是否热门城市(0,否;1,是;)  
	 */
	private Integer isHot;
}