package com.zebra.zebraerp.api.viewobject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 电池修改PO
 * 
 * @author owen
 */
public class BatteryVO {

    private BigDecimal batteryElec;

    private String     batteryCode;

    private Integer    batteryStatus;

    private String     location;

    private BigDecimal gprsRestCharge;

    private String     bikeCode;

    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;
    /**
     * 创建时间
     */
    private Integer createTime;
    
    /**
     * 新增/明细电车时，服务员工是暂时不需要的，等后面在做关联
     */
    private Long   sid;

    public BigDecimal getBatteryElec() {
        return batteryElec;
    }

    public void setBatteryElec(BigDecimal batteryElec) {
        this.batteryElec = batteryElec;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public Integer getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(Integer batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getGprsRestCharge() {
        return gprsRestCharge;
    }

    public void setGprsRestCharge(BigDecimal gprsRestCharge) {
        this.gprsRestCharge = gprsRestCharge;
    }

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
