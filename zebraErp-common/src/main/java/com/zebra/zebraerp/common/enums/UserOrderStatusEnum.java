package com.zebra.zebraerp.common.enums;

/**
 * Created by xiatian on 2018/1/7.
 */
public enum UserOrderStatusEnum {
    /**
     * 用户订单状态
     */
    APPOINTMENT_SUCCESS(1, "预约成功"),
    APPOINTMENT_LOSE(2, "预约到期失效"),
    APPOINTMENT_CANCEL(3, "预约取消"),
    NORMAL_RIDE(4, "正常骑行"),
    OVER_RIDE(5, "结束骑行");


    private Integer orderStatusCode;
    private String orderStatusDes;

    UserOrderStatusEnum(Integer orderStatusCode, String orderStatusDes) {
        this.orderStatusCode = orderStatusCode;
        this.orderStatusDes = orderStatusDes;
    }

    public Integer getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(Integer orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public String getOrderStatusDes() {
        return orderStatusDes;
    }

    public void setOrderStatusDes(String orderStatusDes) {
        this.orderStatusDes = orderStatusDes;
    }
}
