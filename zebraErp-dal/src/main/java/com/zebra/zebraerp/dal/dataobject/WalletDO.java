package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户钱包表DO
 * 
 * @ClassName: WalletDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class WalletDO implements Serializable {

	/** 
	 * 用户主键 ( 主键 ) 
	 */
	private Long uid;
	/** 
	 * 账户余额  
	 */
	private Double balanceAmount;
	/** 
	 * 押金金额  
	 */
	private Double depositAmount;
	/** 
	 * 押金来源(1,支付宝;2,微信;3,钱包;)  
	 */
	private Integer depositSource;
	/** 
	 * 押金帐号(用于回退金额)  
	 */
	private String depositAccount;
	/** 
	 * 押金状态(1:未交押金 2:已交押金 3:退还押金中)  
	 */
	private Integer depositStatus;
	/** 
	 * 押金订单ID  
	 */
	private String depositOrderId;
	/** 
	 * 押金支付类型 1:支付宝，2:微信  
	 */
	private Integer depositPayType;
}