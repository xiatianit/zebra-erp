package com.zebra.zebraerp.api.controller;

import java.util.List;

import com.zebra.pony.util.DateUtil;
import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.biz.service.BikeService;
import com.zebra.zebraerp.biz.service.SiteService;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.util.CollectionUtils;
import com.zebra.zebraerp.common.util.StringUtils;
import com.zebra.zebraerp.dal.dataobject.BikeDO;
import com.zebra.zebraerp.dal.dataobject.SiteDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.api.converter.ServiceStationConverter;
import com.zebra.zebraerp.api.paramobject.ServiceStationAddPO;
import com.zebra.zebraerp.api.paramobject.ServiceStationEditPO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.biz.service.ServiceStationService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.ServiceStationDO;

/**
 * 服务站
 *
 * @author owen
 */
@RestController
@RequestMapping("serviceStation")
public class ServiceStationController {

    private final static Logger logger = LoggerFactory.getLogger(ServiceStationController.class);

    @Autowired
    private ServiceStationService serviceStationService;
    @Autowired
    private SiteService siteService;

    /**
     * 添加服务站信息
     *
     * @param serviceStationAddPO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addServiceStation(ServiceStationAddPO serviceStationAddPO) {
        logger.info("添加服务站信息,serviceStationAddPO={}", JsonUtil.getJsonFromObject(serviceStationAddPO));
        try {
            ServiceStationDO serviceStationDO = ServiceStationConverter.serviceStationAddPO2ServiceStationDO(serviceStationAddPO);
            serviceStationDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            serviceStationDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            serviceStationService.addServiceStation(serviceStationDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "添加服务站信息成功");
        } catch (ZebraerpException e) {
            logger.error("添加服务站信息失败,serviceStationAddPO={},e={}", JsonUtil.getJsonFromObject(serviceStationAddPO), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加服务站信息失败,serviceStationAddPO={},e={}", JsonUtil.getJsonFromObject(serviceStationAddPO), e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 修改服务站信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> updateServiceStation(ServiceStationEditPO serviceStationEditPO) {
        logger.info("修改服务站信息,serviceStationEditPO={}", JsonUtil.getJsonFromObject(serviceStationEditPO));
        try {
            ServiceStationDO serviceStationDO = ServiceStationConverter.serviceStationEditPO2ServiceStationDO(serviceStationEditPO);
            serviceStationService.editServiceStation(serviceStationDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "修改服务站信息成功");
        } catch (ZebraerpException e) {
            logger.error("修改服务站信息失败,serviceStationAddPO={}", JsonUtil.getJsonFromObject(serviceStationEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改服务站信息失败,serviceStationAddPO={}", JsonUtil.getJsonFromObject(serviceStationEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 删除服务站信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteServiceStation(@RequestParam(value = "id", required = true) Long id) {
        logger.info("删除服务站信息,id={}", id);
        try {
            serviceStationService.delServiceStation(id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "删除服务站成功");
        } catch (ZebraerpException e) {
            logger.error("删除服务站信息失败,id={}", id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("删除服务站信息失败,id={}", id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取服务站列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<ServiceStationVO> queryServiceStationList(@RequestParam(value = "serviceStationName", required = false) String serviceStationName,
                                                            @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                            @RequestParam(value = "id", required = false) Long id) {
        logger.info("获取服务站列表信息，serviceStationName={},pageIndex={},id={}", serviceStationName, pageIndex,id);
        try {
            ServiceStationDO serviceStationDO = new ServiceStationDO();
            if (StringUtils.isNotEmpty(serviceStationName)){
                serviceStationDO.setServiceStationName(serviceStationName);
            }
            if (null != id && id > 0){
                serviceStationDO.setId(id);
            }
            serviceStationDO.setPageIndex(pageIndex);
            //如果是加盟商
            if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
                serviceStationDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
                serviceStationDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            }
            List<ServiceStationDO> listData = serviceStationService.queryServiceStationList(serviceStationDO);
            Integer listCount = serviceStationService.queryServiceStationCount(serviceStationDO);
            List<ServiceStationVO> listVo = ServiceStationConverter.serviceStationDO2ServiceStationVO(listData);
            return ResultUtils.genResultWithSuccess("serviceStationList", listVo, "count", listCount);
        } catch (ZebraerpException e) {
            logger.error("获取服务站列表信息，serviceStationName={},pageIndex={},e={}", serviceStationName, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取服务站列表信息，serviceStationName={},pageIndex={},e={}", serviceStationName, pageIndex, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }


    /**
     * 获取单个服务站信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<ServiceStationVO> querySingleServiceStation(@RequestParam(value = "id", required = true) Long id) {
        logger.info("获取单个服务站编号，id={}", id);
        try {
            ServiceStationDO serviceStationDO = serviceStationService.queryServiceStationByPk(id);
            List<SiteDO> siteDOList = siteService.queryByServiceStationId(id);
            //获取服务站单车数量
           /* int serviceStationBikeTotal = 0;
            if (CollectionUtils.isNotEmpty(siteDOList)) {
                for (SiteDO siteDO : siteDOList) {
                    BikeDO bikeDO = new BikeDO();
                    bikeDO.setSiteId(siteDO.getId());
                    int bikeCount = bikeService.queryBikeCount(bikeDO);
                    serviceStationBikeTotal = serviceStationBikeTotal + bikeCount;
                }
            }*/
            ServiceStationVO serviceStationVO = ServiceStationConverter.serviceStationDO2ServiceStationVO(serviceStationDO);
            //服务站服务点数量
            serviceStationVO.setSiteNum(siteDOList.size());
            // serviceStationVO.setBikeNum(serviceStationBikeTotal);
            return ResultUtils.genResultWithSuccess("serviceStationDetail", serviceStationVO);
        } catch (ZebraerpException e) {
            logger.error("获取单个服务站编号，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取单个服务站编号，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }
}

/**
 * 获取单个省份信息
 *
 * @return
 */
// @SuppressWarnings("unchecked")
// @RequestMapping(value = "/province/info", method = RequestMethod.GET)
// public Result<ProvinceDO> querySingleProvince(){
// logger.info("PrefectureController.querySingleProvince,获取单个身份信息");
// try {
// String provinceCode = "10001";
// ProvinceDO provinceDO = provinceService.queryProvinceByPk(provinceCode);
// return ResultUtils.genResultWithSuccess(provinceDO);
// } catch (Exception e) {
// logger.error("PrefectureController.queryProvinceList,获取省份信息列表:{}",e);
// return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
// }
// }
// }
