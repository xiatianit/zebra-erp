package com.zebra.zebraerp.api.controller;

import com.zebra.zebraerp.biz.service.CityService;
import com.zebra.zebraerp.biz.service.ProvinceService;
import com.zebra.zebraerp.biz.service.ZoneService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.dal.dataobject.CityDO;
import com.zebra.zebraerp.dal.dataobject.ProvinceDO;
import com.zebra.zebraerp.dal.dataobject.ZoneDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.pony.common.model.Result;
import com.zebra.pony.common.utils.ResultUtils;

import java.util.List;


/**
 * 行政区域控制层
 *
 * @author owen
 */
@RestController
@RequestMapping("prefecture")
public class PrefectureController {

    private final static Logger logger = LoggerFactory.getLogger(PrefectureController.class);

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ZoneService zoneService;

    /**
     * 获取单个省份信息
     *
     * @return
     */
    @RequestMapping(value = "/province/info", method = RequestMethod.POST)
    public Result<ProvinceDO> querySingleProvince(@RequestParam(value = "provinceCode", required = true) String provinceCode) {
        logger.info("PrefectureController.querySingleProvince,获取单个省份信息");
        try {
            ProvinceDO provinceDO = provinceService.queryProvinceById(provinceCode);
            return ResultUtils.genResultWithSuccess("provinceDetail", provinceDO);
        } catch (ZebraerpException e) {
            logger.error("PrefectureController.queryProvinceList,获取省份信息列表:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("PrefectureController.queryProvinceList,获取省份信息列表:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取省份列表
     *
     * @return
     */
    @RequestMapping(value = "/getProvinceList", method = RequestMethod.POST)
    public Result<?> queryProvinceList() {
        logger.info("queryProvinceList,查询省份列表");
        try {
            List<ProvinceDO> provinceDOList = provinceService.queryProvinceList(new ProvinceDO());
            return ResultUtils.genResultWithSuccess("provinceList", provinceDOList);
        } catch (ZebraerpException e) {
            logger.error("queryProvinceList,获取省份信息列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("queryProvinceList,获取省份信息列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 根据省份code获取城市列表
     *
     * @return
     */
    @RequestMapping(value = "/province/getCityList", method = RequestMethod.POST)
    public Result<?> queryCityListByProvinceCode(@RequestParam(value = "provinceCode", required = true) String provinceCode) {
        logger.info("queryCityListByProvinceCode,根据省份Code查询城市列表");
        try {
            CityDO cityDO = new CityDO();
            cityDO.setProvinceCode(provinceCode);
            List<CityDO> cityDOList = cityService.queryCityList(cityDO);
            return ResultUtils.genResultWithSuccess("cityList", cityDOList);
        } catch (ZebraerpException e) {
            logger.error("queryCityListByProvinceCode,根据省份code获取城市列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("queryCityListByProvinceCode,根据省份code获取城市列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 根据城市code获取区域列表
     *
     * @return
     */
    @RequestMapping(value = "/city/getZoneList", method = RequestMethod.POST)
    public Result<?> queryZoneListByCityCode(@RequestParam(value = "cityCode", required = true) String cityCode) {
        logger.info("queryZoneListByCityCode,根据城市Code查询区域列表");
        try {
            ZoneDO zoneDO = new ZoneDO();
            zoneDO.setCityCode(cityCode);
            List<ZoneDO> zoneDOList = zoneService.queryZoneList(zoneDO);
            return ResultUtils.genResultWithSuccess("zoneList", zoneDOList);
        } catch (ZebraerpException e) {
            logger.error("queryZoneListByCityCode,根据城市code获取区域列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("queryZoneListByCityCode,根据城市code获取区域列表异常:{}", e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

}
