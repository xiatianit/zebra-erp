package com.zebra.zebraerp.dal.dataobject.businessObject;

import java.util.Date;

/**
 * 用户订单表业务BO
 * 
 * @ClassName: CUserOrderBO
 * @Description: by CodeGenerate
 * @author 
 * 
 */
public class UserOrderBO{

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
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getOrderType() {
		return orderType;
	}
	
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPayType() {
		return payType;
	}
	
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayStatus() {
		return payStatus;
	}
	
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Double getStartLatitude() {
		return startLatitude;
	}
	
	public void setStartLatitude(Double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public Double getStartLongitude() {
		return startLongitude;
	}
	
	public void setStartLongitude(Double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public String getStratAddress() {
		return stratAddress;
	}
	
	public void setStratAddress(String stratAddress) {
		this.stratAddress = stratAddress;
	}

	public Double getEndLatitude() {
		return endLatitude;
	}
	
	public void setEndLatitude(Double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public Double getEndLongitude() {
		return endLongitude;
	}
	
	public void setEndLongitude(Double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public String getEndAddress() {
		return endAddress;
	}
	
	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public String getBikeCode() {
		return bikeCode;
	}
	
	public void setBikeCode(String bikeCode) {
		this.bikeCode = bikeCode;
	}

	public String getBatteryCode() {
		return batteryCode;
	}
	
	public void setBatteryCode(String batteryCode) {
		this.batteryCode = batteryCode;
	}

	public Double getTotalDistance() {
		return totalDistance;
	}
	
	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getPayAmount() {
		return payAmount;
	}
	
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayOrderNo() {
		return payOrderNo;
	}
	
	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public Double getKmUnitPrice() {
		return kmUnitPrice;
	}
	
	public void setKmUnitPrice(Double kmUnitPrice) {
		this.kmUnitPrice = kmUnitPrice;
	}

	public Double getHourUnitPrice() {
		return hourUnitPrice;
	}
	
	public void setHourUnitPrice(Double hourUnitPrice) {
		this.hourUnitPrice = hourUnitPrice;
	}

	public Integer getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Integer getBookTime() {
		return bookTime;
	}
	
	public void setBookTime(Integer bookTime) {
		this.bookTime = bookTime;
	}

	public Integer getBookCancelTime() {
		return bookCancelTime;
	}
	
	public void setBookCancelTime(Integer bookCancelTime) {
		this.bookCancelTime = bookCancelTime;
	}

	public Integer getShareClickNum() {
		return shareClickNum;
	}
	
	public void setShareClickNum(Integer shareClickNum) {
		this.shareClickNum = shareClickNum;
	}

	/* -------------------- 非DB字段 -------------------- */
}