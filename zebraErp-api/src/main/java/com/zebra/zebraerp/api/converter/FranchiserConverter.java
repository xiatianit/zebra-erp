package com.zebra.zebraerp.api.converter;

import com.zebra.zebraerp.api.viewobject.BikeChargePriceVO;
import com.zebra.zebraerp.api.viewobject.FranchiserSettlementVO;
import com.zebra.zebraerp.api.viewobject.FranchiserVO;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.DateUtils;
import com.zebra.zebraerp.dal.dataobject.BikeChargePriceDO;
import com.zebra.zebraerp.dal.dataobject.FranchiserBaseDO;
import com.zebra.zebraerp.dal.dataobject.FranchiserSettlementDO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiatian on 2018/1/7.
 */
public class FranchiserConverter {

    public static List<FranchiserVO> franchiserDO2VO(List<FranchiserBaseDO> franchiserBaseDOList) {
        if (CollectionUtils.isEmpty(franchiserBaseDOList)) {
            return null;
        }
        FranchiserVO franchiserVO;
        List<FranchiserVO> franchiserVOList = new ArrayList<>();
        for (FranchiserBaseDO franchiserBase : franchiserBaseDOList) {
            franchiserVO = new FranchiserVO();
            BeanUtils.copyProperties(franchiserBase, franchiserVO);
            franchiserVO.setCreateTime(DateUtils.getDateTime(franchiserBase.getCreateTime()));
            franchiserVOList.add(franchiserVO);
        }
        return franchiserVOList;
    }

    public static FranchiserVO franchiserBaseDO2VODetail(FranchiserBaseDO franchiserBaseDO) {
        if (null == franchiserBaseDO) {
            return null;
        }
        FranchiserVO franchiserVO = new FranchiserVO();
        BeanUtils.copyProperties(franchiserBaseDO, franchiserVO);
        return franchiserVO;

    }

    public static List<FranchiserSettlementVO> franchiserSettlementDO2VO(List<FranchiserSettlementDO> franchiserSettlementDOList) {
        List<FranchiserSettlementVO> franchiserSettlementVOList = new ArrayList<>();
        FranchiserSettlementVO franchiserSettlementVO;
        for (FranchiserSettlementDO franchiserSettlementDO : franchiserSettlementDOList) {
            franchiserSettlementVO = new FranchiserSettlementVO();
            BeanUtils.copyProperties(franchiserSettlementDO, franchiserSettlementVO);
            franchiserSettlementVOList.add(franchiserSettlementVO);
        }
        return franchiserSettlementVOList;
    }


    public static List<BikeChargePriceVO> bikeChargePriceDO2VO(List<BikeChargePriceDO> bikeChargePriceDOList) {
        List<BikeChargePriceVO> bikeChargePriceVOList = new ArrayList<>();
        BikeChargePriceVO bikeChargePriceVO;
        for (BikeChargePriceDO bikeChargePriceDO : bikeChargePriceDOList) {
            bikeChargePriceVO = new BikeChargePriceVO();
            BeanUtils.copyProperties(bikeChargePriceDO, bikeChargePriceVO);
            bikeChargePriceVOList.add(bikeChargePriceVO);
        }
        return bikeChargePriceVOList;
    }


}
