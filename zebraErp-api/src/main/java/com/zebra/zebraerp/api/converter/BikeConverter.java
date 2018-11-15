package com.zebra.zebraerp.api.converter;

import java.util.ArrayList;
import java.util.List;

import com.zebra.zebraerp.api.viewobject.BikeModelVO;
import com.zebra.zebraerp.api.viewobject.FranchiserBikeUseVO;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.dal.dataobject.BikeModelDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.FranchiserBikeUseBO;
import org.springframework.beans.BeanUtils;

import com.zebra.zebraerp.api.paramobject.BikeAddPO;
import com.zebra.zebraerp.api.paramobject.BikeEditPO;
import com.zebra.zebraerp.api.viewobject.BikeDetailVO;
import com.zebra.zebraerp.api.viewobject.BikeVO;
import com.zebra.zebraerp.dal.dataobject.BikeDO;

/**
 * 电车转换
 *
 * @author owen
 */
public class BikeConverter {

    public static BikeDO bikeAddPO2BBikeDO(BikeAddPO bikeAddPO) {
        if (bikeAddPO == null) {
            return null;
        }
        BikeDO bikeDO = new BikeDO();
        BeanUtils.copyProperties(bikeAddPO, bikeDO);
        if ("2".equals(bikeAddPO.getBikeModel()) || "三轮车".equals(bikeAddPO.getBikeModel())) {
            bikeDO.setBikeModel("三轮车");
        } else {
            bikeDO.setBikeModel("两轮车");
        }
        bikeDO.setBikeCode(bikeDO.getGprsPhone());
        return bikeDO;
    }

    public static BikeDO bikeEditPO2BBikeDO(BikeEditPO bikeEditPO) {
        if (bikeEditPO == null) {
            return null;
        }
        BikeDO bikeDO = new BikeDO();
        BeanUtils.copyProperties(bikeEditPO, bikeDO);
        if ("2".equals(bikeEditPO.getBikeModel()) || "三轮车".equals(bikeEditPO.getBikeModel())) {
            bikeDO.setBikeModel("三轮车");
        } else {
            bikeDO.setBikeModel("两轮车");
        }
        bikeDO.setBikeCode(bikeDO.getGprsPhone());
        return bikeDO;
    }

    public static BikeVO bikeDO2BBikeVO(BikeDO bikeDO) {
        if (bikeDO == null) {
            return null;
        }
        BikeVO bikeVO = new BikeVO();
        BeanUtils.copyProperties(bikeDO, bikeVO);
        bikeVO.setLocation(bikeDO.getLongitude() + "," + bikeDO.getLatitude());
        return bikeVO;
    }

    public static BikeDetailVO bikeDO2BBikeDetailVO(BikeDO bikeDO) {
        if (bikeDO == null) {
            return null;
        }
        BikeDetailVO bikeDetailVO = new BikeDetailVO();
        BeanUtils.copyProperties(bikeDO, bikeDetailVO);
        return bikeDetailVO;
    }

    public static List<BikeVO> bikeDO2BBikeVO(List<BikeDO> bikeDOList) {
        if (bikeDOList == null) {
            return null;
        }

        List<BikeVO> bikeVOList = new ArrayList<BikeVO>(bikeDOList.size());
        BikeVO bikeVO = null;
        for (BikeDO bikeDO : bikeDOList) {
            bikeVO = BikeConverter.bikeDO2BBikeVO(bikeDO);
            bikeVOList.add(bikeVO);
        }
        return bikeVOList;
    }

    public static List<BikeModelVO> bikeModelDO2BikeModelVO(List<BikeModelDO> bikeModelDOList) {
        if (CollectionUtils.isEmpty(bikeModelDOList)) {
            return null;
        }
        List<BikeModelVO> bikeModelVOList = new ArrayList<>();
        BikeModelVO bikeModelVO;
        for (BikeModelDO bikeModelDO : bikeModelDOList) {
            bikeModelVO = new BikeModelVO();
            BeanUtils.copyProperties(bikeModelDO, bikeModelVO);
            bikeModelVOList.add(bikeModelVO);
        }
        return bikeModelVOList;
    }

    public static List<FranchiserBikeUseVO> franchiserBikeUseBO2VO(List<FranchiserBikeUseBO> franchiserBikeUseBOList) {
        if (CollectionUtils.isEmpty(franchiserBikeUseBOList)) {
            return null;
        }

        List<FranchiserBikeUseVO> franchiserBikeUseVOS = new ArrayList<>();
        FranchiserBikeUseVO franchiserBikeUseVO;
        for (FranchiserBikeUseBO franchiserBikeUseBO : franchiserBikeUseBOList) {
            franchiserBikeUseVO = new FranchiserBikeUseVO();
            BeanUtils.copyProperties(franchiserBikeUseBO, franchiserBikeUseVO);
            franchiserBikeUseVOS.add(franchiserBikeUseVO);
        }
        return franchiserBikeUseVOS;
    }

}
