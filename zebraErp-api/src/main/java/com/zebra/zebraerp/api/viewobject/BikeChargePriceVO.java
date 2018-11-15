package com.zebra.zebraerp.api.viewobject;

import lombok.Data;
import lombok.ToString;

/**
 * Created by xiatian on 2018/1/15.
 */
@Data
@ToString
public class BikeChargePriceVO {

    /**
     * 主键 ( 主键 )
     */
    private Long id;
    /**
     * 车型编号
     */
    private String bikeModelCode;
    /**
     * 车型名称
     */
    private String bikeModelName;
    /**
     * 单价（元）
     */
    private Double unitPrice;
    /**
     * 最小单元10分钟，15分钟，20分钟
     */
    private Integer unit;
    /**
     * 所属加盟商编号
     */
    private String franchiserCode;
    /**
     * 所属加盟商名称
     */
    private String franchiserName;
}
