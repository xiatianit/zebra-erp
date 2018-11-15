package com.zebra.zebraerp.api.viewobject;

/**
 * 投放点VO
 *
 * @author xiatian
 */
public class SiteVO {

    /**
     * 投放点ID
     */
    private Long id;

    /**
     * 地理位置经纬度，如：120.145156,30.1516
     */
    private String location;

    /**
     * 投放点名称
     */
    private String siteName;
    /**
     * 投放点地址
     */
    private String siteAddress;

    /**
     * 投放点状态：1、正常开放 2、关闭
     */
    private Integer siteStatus;
    /**
     * /**
     * 服务站名称
     */
    private String serviceStationName;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;

    /**
     * 所属加盟商编号
     */
    private String franchiserCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public Integer getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(Integer siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getFranchiserCode() {
        return franchiserCode;
    }

    public void setFranchiserCode(String franchiserCode) {
        this.franchiserCode = franchiserCode;
    }

    public String getServiceStationName() {
        return serviceStationName;
    }

    public void setServiceStationName(String serviceStationName) {
        this.serviceStationName = serviceStationName;
    }

    public String getFranchiserName() {
        return franchiserName;
    }

    public void setFranchiserName(String franchiserName) {
        this.franchiserName = franchiserName;
    }
}
