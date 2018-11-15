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
public class UserConsumeDO extends PageDO implements Serializable {

	/** 
	 * 用户主键 ( 主键 ) 
	 */
	private Long uid;
	/** 
	 * 注册手机  
	 */
	private String phone;
	/**
	 * 消费总金额
	 */
	private Double consumeAmount;
	/**
	 * 押金状态
	 */
	private Integer depositStatus;
	/**
	 * 所属加盟商编号
	 */
	private String franchiserCode;
}