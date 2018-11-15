package com.zebra.zebraerp.api.viewobject;

import java.util.Date;

/**
 * 新增服务站
 * 
 * @author owen
 *
 */
public class BikeDetailVO {

    private String bikeNo;

    private String  bikeCode;
    /**
     * 投放点编码
     */
    private Long siteId;
    /**
     * 投放点名称
     */
    private String siteName;
    /**
     * 电车终端地址
     */
    private String currentAddress;
    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;

    private String  bikeModel;

    private Integer bikeStatus;

    /**
     * 电池编号
     */
    private String batteryCode;

    /**
     * GPRS手机号码
     */
    private String gprsPhone;
    /**
     * 创建日期
     */
    private Integer createTime;
    /**
     * 电池电量(单位:%)
     */
    private Integer batteryElec;

    public String getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getFranchiserCode() {
        return franchiserCode;
    }

    public void setFranchiserCode(String franchiserCode) {
        this.franchiserCode = franchiserCode;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public Integer getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(Integer bikeStatus) {
        this.bikeStatus = bikeStatus;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public String getGprsPhone() {
        return gprsPhone;
    }

    public void setGprsPhone(String gprsPhone) {
        this.gprsPhone = gprsPhone;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getBatteryElec() {
        return batteryElec;
    }

    public void setBatteryElec(Integer batteryElec) {
        this.batteryElec = batteryElec;
    }
}
