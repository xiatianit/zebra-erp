package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum UserOrderPayStatusEnum {
    /**
     * 订单支付状态
     */
    NOT_PAY(1, "未支付"),
    HAVE_PAY(2, "已支付");


    private Integer payStatusCode;
    private String payStatusDes;

    UserOrderPayStatusEnum(Integer payStatusCode, String payStatusDes) {
        this.payStatusCode = payStatusCode;
        this.payStatusDes = payStatusDes;
    }

    public Integer getPayStatusCode() {
        return payStatusCode;
    }

    public void setPayStatusCode(Integer payStatusCode) {
        this.payStatusCode = payStatusCode;
    }

    public String getPayStatusDes() {
        return payStatusDes;
    }

    public void setPayStatusDes(String payStatusDes) {
        this.payStatusDes = payStatusDes;
    }
}
