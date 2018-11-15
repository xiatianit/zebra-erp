package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 加盟商基础信息表DO
 * 
 * @ClassName: FranchiserBaseDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class FranchiserBaseDO extends PageDO implements Serializable {

	/** 
	 * 加盟商编号 ( 主键 ) 
	 */
	private String franchiserCode;
	/** 
	 * 加盟商手机号码  
	 */
	private String phone;
	/** 
	 * 加盟商名称  
	 */
	private String franchiserName;
	/** 
	 * 省份代码  
	 */
	private String provinceCode;
	/** 
	 * 省份名称  
	 */
	private String provinceName;
	/** 
	 * 城市code  
	 */
	private String cityCode;
	/** 
	 * 城市名称  
	 */
	private String cityName;
	/** 
	 * 区域code  
	 */
	private String zoneCode;
	/** 
	 * 区域名称  
	 */
	private String zoneName;
	/** 
	 * 加盟商密码  
	 */
	private String password;
	/** 
	 * 加盟商状态0-正常，1-退出  
	 */
	private Integer status;
	/** 
	 * 修改日期  
	 */
	private Date modifiedTime;
	/** 
	 * 创建日期  
	 */
	private Date createTime;
}