package com.zebra.zebraerp.api.viewobject;



/**
 * 加盟商运营情况
 *
 * @author owen
 */
public class OperateInfoVO {

    /**
     * 总投放数量
     */
    private Integer totalBikeNum;
    /**
     * 总用户数
     */
    private Integer totalUserNum;
    /**
     * 总订单数
     */
    private Integer totalOrderNum;
    /**
     * 总收入
     */
    private Double totalIncom;
    /**
     * 客单价
     */
    private Double userEveryPay;
    /**
     * 客均单
     */
    private Double userAverageNum;
    /**
     * 笔单价
     */
    private Double orderEveryPay;

    public Integer getTotalBikeNum() {
        return totalBikeNum;
    }

    public void setTotalBikeNum(Integer totalBikeNum) {
        this.totalBikeNum = totalBikeNum;
    }

    public Integer getTotalUserNum() {
        return totalUserNum;
    }

    public void setTotalUserNum(Integer totalUserNum) {
        this.totalUserNum = totalUserNum;
    }

    public Integer getTotalOrderNum() {
        return totalOrderNum;
    }

    public void setTotalOrderNum(Integer totalOrderNum) {
        this.totalOrderNum = totalOrderNum;
    }

    public Double getTotalIncom() {
        return totalIncom;
    }

    public void setTotalIncom(Double totalIncom) {
        this.totalIncom = totalIncom;
    }

    public Double getUserEveryPay() {
        return userEveryPay;
    }

    public void setUserEveryPay(Double userEveryPay) {
        this.userEveryPay = userEveryPay;
    }

    public Double getUserAverageNum() {
        return userAverageNum;
    }

    public void setUserAverageNum(Double userAverageNum) {
        this.userAverageNum = userAverageNum;
    }

    public Double getOrderEveryPay() {
        return orderEveryPay;
    }

    public void setOrderEveryPay(Double orderEveryPay) {
        this.orderEveryPay = orderEveryPay;
    }
}
