package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 加盟商结算申请表DO
 * 
 * @ClassName: FranchiserSettlementDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class FranchiserSettlementDO extends PageDO implements Serializable {

	/** 
	 * 主键 ( 主键 ) 
	 */
	private Long id;
	/** 
	 * 结算金额  
	 */
	private Double settlementAmount;
	/** 
	 * 所属加盟商编号  
	 */
	private String franchiserCode;
	/** 
	 * 所属加盟商名称  
	 */
	private String franchiserName;
	/** 
	 * 结算状态0-待转账，1-已转账，2-拒绝  
	 */
	private Integer status;
	/** 
	 * 申请日期  
	 */
	private Date applyTime;
}