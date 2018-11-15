package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum SettlementStatusEnum {
    /**
     * 加盟商申请结算状态
     */
    WAIT_TRANSFER(0, "待转账"),
    HAVED_TRANSFER(1, "已转账"),
    REFUSE_TRANSFER(2, "拒绝转账");


    SettlementStatusEnum(Integer transferStatusCode, String fransferStatusDes) {
        this.transferStatusCode = transferStatusCode;
        this.fransferStatusDes = fransferStatusDes;
    }

    private Integer transferStatusCode;
    private String fransferStatusDes;

    public Integer getTransferStatusCode() {
        return transferStatusCode;
    }

    public void setTransferStatusCode(Integer transferStatusCode) {
        this.transferStatusCode = transferStatusCode;
    }

    public String getFransferStatusDes() {
        return fransferStatusDes;
    }

    public void setFransferStatusDes(String fransferStatusDes) {
        this.fransferStatusDes = fransferStatusDes;
    }
}
