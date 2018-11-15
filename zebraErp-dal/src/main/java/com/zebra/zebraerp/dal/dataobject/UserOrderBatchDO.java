package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 用户订单表DO
 * 
 * @ClassName: UserOrderDO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
@Data
@ToString
public class UserOrderBatchDO extends PageDO implements Serializable {

	/** 
	 * 订单ID ( 主键 ) 
	 */
	private String orderId;
	/** 
	 * 用户ID  
	 */
	private Long uid;
	/** 
	 * 用户昵称  
	 */
	private String nickName;
	/** 
	 * 订单类型 (1、线上预约订单 2、线下订单)  
	 */
	private Integer orderType;
	/** 
	 * 订单状态 (1、预约成功 2、预约到期失效 3、预约取消失效 4、正常骑行中 5、结束骑行)  
	 */
	private Integer orderStatus;
	/** 
	 * 支付类型 (1、支付宝 2、微信）  
	 */
	private Integer payType;
	/** 
	 * 支付状态 (1、未支付 2、已支付)  
	 */
	private Integer payStatus;
	/** 
	 * 开始位置经度  
	 */
	private Double startLatitude;
	/** 
	 * 开始位置纬度  
	 */
	private Double startLongitude;
	/** 
	 * 开始位置地址  
	 */
	private String stratAddress;
	/** 
	 * 结束位置经度  
	 */
	private Double endLatitude;
	/** 
	 * 结束位置纬度  
	 */
	private Double endLongitude;
	/** 
	 * 结束位置地址  
	 */
	private String endAddress;
	/** 
	 * 电车编码  
	 */
	private String bikeCode;
	/** 
	 * 电池编码  
	 */
	private String batteryCode;
	/** 
	 * 骑行总路程  
	 */
	private Double totalDistance;
	/** 
	 * 订单总金额  
	 */
	private Double totalAmount;
	/** 
	 * 实际支付金额  
	 */
	private Double payAmount;
	/** 
	 * 支付单号  
	 */
	private String payOrderNo;
	/** 
	 * 里程单价(元)  
	 */
	private Double kmUnitPrice;
	/** 
	 * 时间单价(元)  
	 */
	private Double hourUnitPrice;
	/** 
	 * 开始时间  
	 */
	private Integer startTime;
	/** 
	 * 结束时间  
	 */
	private Integer endTime;
	/** 
	 * 预约时间  
	 */
	private Integer bookTime;
	/** 
	 * 预约取消时间  
	 */
	private Integer bookCancelTime;
	/** 
	 * 分享点击次数  
	 */
	private Integer shareClickNum;
	/**
	 * 订单是否已被加盟商申请结算
	 */
	private Integer isApply;
	/**
	 * 订单所属的申请结算记录ID
	 */
	private Long settlementId;
	/**
	 * 批量的用户订单
	 */
	private List<String> orderIds;
}