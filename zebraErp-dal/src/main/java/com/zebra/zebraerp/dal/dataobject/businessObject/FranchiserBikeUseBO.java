package com.zebra.zebraerp.dal.dataobject.businessObject;

/**
 * Created by xiatian on 2018/1/18.
 */
public class FranchiserBikeUseBO {

    /**
     * 日期
     */
    private String dateTime;
    /**
     * 每日单车使用数量
     */
    private Integer dayBikeUseNum;
    /**
     * 每天使用率
     */
    private Double dayUseRate;
    /**
     * 每日订单数量
     */
    private Integer dayOrderNum;
    /**
     * 每日用户数
     */
    private Integer  dayUserNum;
    /**
     * 每日收入
     */
    private Double dayIncom;
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
    /**
     * 今日投放单车总数量
     */
    private Integer totalBikeNum;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getDayBikeUseNum() {
        return dayBikeUseNum;
    }

    public void setDayBikeUseNum(Integer dayBikeUseNum) {
        this.dayBikeUseNum = dayBikeUseNum;
    }

    public Double getDayUseRate() {
        return dayUseRate;
    }

    public void setDayUseRate(Double dayUseRate) {
        this.dayUseRate = dayUseRate;
    }

    public Integer getDayOrderNum() {
        return dayOrderNum;
    }

    public void setDayOrderNum(Integer dayOrderNum) {
        this.dayOrderNum = dayOrderNum;
    }

    public Integer getDayUserNum() {
        return dayUserNum;
    }

    public void setDayUserNum(Integer dayUserNum) {
        this.dayUserNum = dayUserNum;
    }

    public Double getDayIncom() {
        return dayIncom;
    }

    public void setDayIncom(Double dayIncom) {
        this.dayIncom = dayIncom;
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

    public Integer getTotalBikeNum() {
        return totalBikeNum;
    }

    public void setTotalBikeNum(Integer totalBikeNum) {
        this.totalBikeNum = totalBikeNum;
    }
}
