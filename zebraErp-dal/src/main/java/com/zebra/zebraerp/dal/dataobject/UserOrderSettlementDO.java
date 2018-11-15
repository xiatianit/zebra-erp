package com.zebra.zebraerp.dal.dataobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户订单表DO
 *
 * @author
 * @ClassName: UserOrderDO
 * @Description: by CodeGenerate
 */
@Data
@ToString
public class UserOrderSettlementDO extends PageDO implements Serializable {


    /**
     * 订单申请结算当天开始时间
     */
    private Integer appyTime;
    /**
     * 申请加盟商code
     */
    private String franchiserCode;
    /**
     * 是否已经申请计算
     */
    private Integer isApply;
    /**
     * 支付状态
     */
    private Integer payStatus;
}