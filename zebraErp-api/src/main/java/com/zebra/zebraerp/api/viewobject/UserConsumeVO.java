package com.zebra.zebraerp.api.viewobject;

/**
 * Created by xiatian on 2018/1/14.
 */
public class UserConsumeVO {

    /**
     * 用户主键 ( 主键 )
     */
    private Long uid;
    /**
     * 注册手机
     */
    private String phone;
    /**
     * 消费总金额
     */
    private Double consumeAmount;
    /**
     * 押金状态
     */
    private Integer depositStatus;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Integer getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(Integer depositStatus) {
        this.depositStatus = depositStatus;
    }
}
