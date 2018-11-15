package com.zebra.zebraerp.common.constant;

/**
 * zebraErp变量
 * @author owen
 *
 */
public interface ZebraerpConstant {

    String REDIS_PREFIX_ERP_TOKEN = "erp_token_";

    /** 用户token失效时间 24 * 60 * 60 */
    int    erpTokenEffectiveTime         = 86400;

    /** 服务站功能类型 1、全部 2、维修 3、电池充电 4、其他 */
    int SERVICE_STATION_FUNCTION_TYPE_1 = 1;
    int SERVICE_STATION_FUNCTION_TYPE_2 = 2;
    int SERVICE_STATION_FUNCTION_TYPE_3 = 3;
    int SERVICE_STATION_FUNCTION_TYPE_4 = 4;
    
    /** 服务站状态：1、正常开放 2、关闭 */
    int SERVICE_STATION_STATUS_1 = 1;
    int SERVICE_STATION_STATUS_2 = 2;
    
    /** 站点 绑定类型 列出所有关联投放点或者未关联投放点  1:已关联  2:未关联 3:所有 */
    int SITE_BUNDLED_STATUS_1 = 1;
    int SITE_BUNDLED_STATUS_2 = 3;
    int SITE_BUNDLED_STATUS_3 = 3;
    
    /** 电池状态(1、未投放 2、使用中 3、已报废) */
    int BATTERY_STATUS_1 = 1;
    int BATTERY_STATUS_2 = 2;
    int BATTERY_STATUS_3 = 3;
    
    /** 电车bike 单车状态(1、未投放 2、已预约 3、未行使 4、行使中  5、需更换电池 6、需复位 7、复位中、8、需维护 9、维护返场中、10、维护中 11、已报废)*/
    int BIKE_STATUS_1 = 1;
    int BIKE_STATUS_2 = 2;
    int BIKE_STATUS_3 = 3;
    int BIKE_STATUS_4 = 4;
    int BIKE_STATUS_5 = 5;
    int BIKE_STATUS_6 = 6;
    int BIKE_STATUS_7 = 7;
    int BIKE_STATUS_8 = 8;
    int BIKE_STATUS_9 = 9;
    int BIKE_STATUS_10 = 10;
    int BIKE_STATUS_11 = 11;
    
    
    /** 全局变量 分页，每页显示页码数*/
    int ZEBRAERP_GLOBAL_ROWS=10;
    
    
}
