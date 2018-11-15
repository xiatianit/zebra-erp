package com.zebra.zebraerp.api.converter;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.api.viewobject.UserOrderDetailVO;
import com.zebra.zebraerp.api.viewobject.UserConsumeVO;
import com.zebra.zebraerp.common.enums.UserDepositEnum;
import com.zebra.zebraerp.dal.dataobject.UserConsumeDO;
import com.zebra.zebraerp.dal.dataobject.UserOrderDO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiatian on 2018/1/14.
 */
public class UserConverter {

    public static List<UserConsumeVO> UserConsumeDO2VO(List<UserConsumeDO> userConsumeDOList) {
        List<UserConsumeVO> userConsumeListVO = new ArrayList<>();
        UserConsumeVO userConsumeVO;
        for (UserConsumeDO userConsumeDO : userConsumeDOList) {
            userConsumeVO = new UserConsumeVO();
            BeanUtils.copyProperties(userConsumeDO, userConsumeVO);
            userConsumeListVO.add(userConsumeVO);
        }
        return userConsumeListVO;
    }

    public static List<UserOrderDetailVO> UserOrderDO2UserOrderDetailVO(List<UserOrderDO> userOrderDOList) {

        List<UserOrderDetailVO> userOrderDetailVOList = new ArrayList<>();
        UserOrderDetailVO userOrderDetailVO;
        for (UserOrderDO userOrderDO : userOrderDOList) {
            userOrderDetailVO = new UserOrderDetailVO();
            BeanUtils.copyProperties(userOrderDO, userOrderDetailVO);
           /* userOrderDetailVO.setOrderStartTime(DateUtil.formatyyyyMMddHHmm(userOrderDO.getStartTime().longValue()));
            userOrderDetailVO.setOrderEndTime(DateUtil.formatyyyyMMddHHmm(userOrderDO.getEndTime().longValue()));*/
            userOrderDetailVOList.add(userOrderDetailVO);
        }
        return userOrderDetailVOList;

    }

}
