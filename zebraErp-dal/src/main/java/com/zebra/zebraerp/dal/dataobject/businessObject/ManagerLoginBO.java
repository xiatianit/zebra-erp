package com.zebra.zebraerp.dal.dataobject.businessObject;

/**
 * Created by xiatian on 2018/1/7.
 */
public class ManagerLoginBO {

    private String token;
    private Integer managerRoleType;
    private String phone;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getManagerRoleType() {
        return managerRoleType;
    }

    public void setManagerRoleType(Integer managerRoleType) {
        this.managerRoleType = managerRoleType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
