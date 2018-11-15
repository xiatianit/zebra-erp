package com.zebra.zebraerp.api.paramobject;

/**
 * 电车新增PO
 * 
 * @author owen
 */
public class BikeAddPO {


    private String bikeNo;

    private String  bikeModel;

    private Integer bikeStatus;

    /***
     * 新增电车时，投放点是暂时不需要的，等后面在做关联
     */
    private Long    siteId;

    /**
     * 新增电车时，服务员工是暂时不需要的，等后面在做关联
     */
    private Long    sid;

    private String  bikePlateNo;

    /**
     * 时间戳
     */
    private Integer plateEndTime;
    /**
     * GPRS_PHONE
     */
    private String gprsPhone;
    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;

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

    public Integer getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(Integer bikeStatus) {
        this.bikeStatus = bikeStatus;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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

    public String getGprsPhone() {
        return gprsPhone;
    }

    public void setGprsPhone(String gprsPhone) {
        this.gprsPhone = gprsPhone;
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
}
