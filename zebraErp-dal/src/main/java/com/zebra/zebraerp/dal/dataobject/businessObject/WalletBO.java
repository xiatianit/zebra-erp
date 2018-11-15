package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.util.Date;

/**
 * 用户钱包表业务BO
 * 
 * @ClassName: CWalletBO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public class WalletBO{

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
	
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}
	
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}
	
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Integer getDepositSource() {
		return depositSource;
	}
	
	public void setDepositSource(Integer depositSource) {
		this.depositSource = depositSource;
	}

	public String getDepositAccount() {
		return depositAccount;
	}
	
	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	public Integer getDepositStatus() {
		return depositStatus;
	}
	
	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getDepositOrderId() {
		return depositOrderId;
	}
	
	public void setDepositOrderId(String depositOrderId) {
		this.depositOrderId = depositOrderId;
	}

	public Integer getDepositPayType() {
		return depositPayType;
	}
	
	public void setDepositPayType(Integer depositPayType) {
		this.depositPayType = depositPayType;
	}

	/* -------------------- 非DB字段 -------------------- */
}