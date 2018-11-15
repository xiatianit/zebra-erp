package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum UserDepositEnum {
    /**
     * 用户押金状态
     */
    WEIJIAO_DEPOSIT(1, "未交押金"),
    YIJIAO_DEPOSIT(2, "已交押金"),
    TUIHUAN_DEPOSIT(3, "退还押金中");


    UserDepositEnum(Integer depositStatusCode, String depositStatusDes) {
        this.depositStatusCode = depositStatusCode;
        this.depositStatusDes = depositStatusDes;
    }

    private Integer depositStatusCode;
    private String depositStatusDes;

    public Integer getDepositStatusCode() {
        return depositStatusCode;
    }

    public void setDepositStatusCode(Integer depositStatusCode) {
        this.depositStatusCode = depositStatusCode;
    }

    public String getDepositStatusDes() {
        return depositStatusDes;
    }

    public void setDepositStatusDes(String depositStatusDes) {
        this.depositStatusDes = depositStatusDes;
    }
}
