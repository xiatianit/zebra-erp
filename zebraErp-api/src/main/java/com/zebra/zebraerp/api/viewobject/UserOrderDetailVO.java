package com.zebra.zebraerp.api.viewobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户消费详情VO
 *
 * @author
 * @ClassName: UserBaseDO
 * @Description: by CodeGenerate
 */
@Data
@ToString
public class UserOrderDetailVO {

    /**
     * 订单ID ( 主键 )
     */
    private String orderId;
    /**
     * 用户ID
     */
    private Long uid;
    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 订单状态 (1、预约成功 2、预约到期失效 3、预约取消失效 4、正常骑行中 5、结束骑行)
     */
    private Integer orderStatus;
    /**
     * 支付类型 (1、支付宝 2、微信）
     */
    private Integer payType;
    /**
     * 支付状态 (1、未支付 2、已支付)
     */
    private Integer payStatus;
    /**
     * 电车编码
     */
    private String bikeCode;
    /**
     * 订单总金额
     */
    private Double totalAmount;
    /**
     * 实际支付金额
     */
    private Double payAmount;
    /**
     * 开始时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;
}