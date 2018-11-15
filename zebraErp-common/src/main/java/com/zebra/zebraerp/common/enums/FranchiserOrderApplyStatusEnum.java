package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum FranchiserOrderApplyStatusEnum {

    NOT_APPLY(0, "未申请"),
    HAVED_APPLY(1, "已申请");


    private Integer applyStatusCode;
    private String applyStatusDes;

    FranchiserOrderApplyStatusEnum(Integer applyStatusCode, String applyStatusDes) {
        this.applyStatusCode = applyStatusCode;
        this.applyStatusDes = applyStatusDes;
    }

    public Integer getApplyStatusCode() {
        return applyStatusCode;
    }

    public void setApplyStatusCode(Integer applyStatusCode) {
        this.applyStatusCode = applyStatusCode;
    }

    public String getApplyStatusDes() {
        return applyStatusDes;
    }

    public void setApplyStatusDes(String applyStatusDes) {
        this.applyStatusDes = applyStatusDes;
    }
}
