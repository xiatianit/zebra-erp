package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * erp管理员token表DO
 * 
 * @ClassName: ErpManagerTokenDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class ErpManagerTokenDO implements Serializable {

	private static final long serialVersionUID = 667004154076904590L;
	/**
	 * id ( 主键 ) 
	 */
	private Long id;
	/** 
	 * 管理员id  
	 */
	private Long managerId;
	/** 
	 * 用户token  
	 */
	private String token;
	/** 
	 * 最后一次更新时间  
	 */
	private Date lastUpdateTime;
}