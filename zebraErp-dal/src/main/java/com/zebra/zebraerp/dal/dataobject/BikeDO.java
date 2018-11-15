package com.zebra.zebraerp.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电车DO
 * 
 */
public class BikeDO extends PageDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 单车编号 ( 主键 )
     */
    private String bikeCode;

    private String bikeNo;
    /**
     * 单车类型
     */
    private String bikeModel;
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
     * 投放点编码
     */
    private Long siteId;
    /**
     * 投放点名称
     */
    private String siteName;
    /**
     * 车牌号
     */
    private String bikePlateNo;
    /**
     * 车牌到期时间
     */
    private Integer plateEndTime;
    /**
     * 单车来源
     */
    private Integer bikeSource;
    /**
     * 单车状态(1、未投放 2、已预约 3、未行使 4、行使中  5、需更换电池 6、需复位 7、复位中、8、需维护 9、维护返场中、10、维护中 11、已报废 12、临时停车)
     */
    private Integer bikeStatus;
    /**
     * 电池编号
     */
    private String batteryCode;
    /**
     * 经度
     */
    private Double latitude;
    /**
     * 纬度
     */
    private Double longitude;
    /**
     * 电车终端地址
     */
    private String currentAddress;
    /**
     * 限行区域
     */
    private String limitArea;
    /**
     * 开始运营时间
     */
    private Integer operaTime;
    /**
     * 保修开始时间
     */
    private Integer warrantyStart;
    /**
     * 保修结束时间
     */
    private Integer warrantyEnd;
    /**
     * 保修备注
     */
    private String warrantyRemark;
    /**
     * 电车服务人员编号
     */
    private Long sid;
    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;
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
    /**
     * 剩余里程数(单位:KM)
     */
    private Double restMileage;

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    public String getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
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

    public String getBikePlateNo() {
        return bikePlateNo;
    }

    public void setBikePlateNo(String bikePlateNo) {
        this.bikePlateNo = bikePlateNo;
    }

    public Integer getPlateEndTime() {
        return plateEndTime;
    }

    public void setPlateEndTime(Integer plateEndTime) {
        this.plateEndTime = plateEndTime;
    }

    public Integer getBikeSource() {
        return bikeSource;
    }

    public void setBikeSource(Integer bikeSource) {
        this.bikeSource = bikeSource;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getLimitArea() {
        return limitArea;
    }

    public void setLimitArea(String limitArea) {
        this.limitArea = limitArea;
    }

    public Integer getOperaTime() {
        return operaTime;
    }

    public void setOperaTime(Integer operaTime) {
        this.operaTime = operaTime;
    }

    public Integer getWarrantyStart() {
        return warrantyStart;
    }

    public void setWarrantyStart(Integer warrantyStart) {
        this.warrantyStart = warrantyStart;
    }

    public Integer getWarrantyEnd() {
        return warrantyEnd;
    }

    public void setWarrantyEnd(Integer warrantyEnd) {
        this.warrantyEnd = warrantyEnd;
    }

    public String getWarrantyRemark() {
        return warrantyRemark;
    }

    public void setWarrantyRemark(String warrantyRemark) {
        this.warrantyRemark = warrantyRemark;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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

    public Double getRestMileage() {
        return restMileage;
    }

    public void setRestMileage(Double restMileage) {
        this.restMileage = restMileage;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
