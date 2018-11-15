package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum RoleTypeEnum {

    GOVERNMENT_TYPE(1, "官方"),
    FRANCHISER_TYPE(2, "加盟商");

    RoleTypeEnum(Integer roleTypeCode, String roleTypeDes) {
        this.roleTypeCode = roleTypeCode;
        this.roleTypeDes = roleTypeDes;
    }

    private Integer roleTypeCode;
    private String roleTypeDes;

    public Integer getRoleTypeCode() {
        return roleTypeCode;
    }

    public void setRoleTypeCode(Integer roleTypeCode) {
        this.roleTypeCode = roleTypeCode;
    }

    public String getRoleTypeDes() {
        return roleTypeDes;
    }

    public void setRoleTypeDes(String roleTypeDes) {
        this.roleTypeDes = roleTypeDes;
    }
}
