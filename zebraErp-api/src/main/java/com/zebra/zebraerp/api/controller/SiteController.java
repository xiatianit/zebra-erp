package com.zebra.zebraerp.api.controller;

import java.util.Arrays;
import java.util.List;

import com.zebra.zebraerp.api.Interceptor.RequestLocalInfo;
import com.zebra.zebraerp.common.enums.RoleTypeEnum;
import com.zebra.zebraerp.common.util.StringUtils;
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
import com.zebra.zebraerp.api.converter.SiteConverter;
import com.zebra.zebraerp.api.paramobject.SiteAddPO;
import com.zebra.zebraerp.api.paramobject.SiteEditPO;
import com.zebra.zebraerp.api.viewobject.ServiceStationVO;
import com.zebra.zebraerp.api.viewobject.SiteVO;
import com.zebra.zebraerp.biz.service.SiteService;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.constant.ZebraerpConstant;
import com.zebra.zebraerp.dal.dataobject.SiteDO;
import com.zebra.zebraerp.dal.dataobject.businessObject.SiteBO;

/**
 * 投放点
 *
 * @author owen
 */
@RestController
@RequestMapping("site")
public class SiteController {

    private final static Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private SiteService siteService;

    /**
     * 添加投放点信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addSite(SiteAddPO siteAddPO) {
        logger.info("添加投放点信息,siteAddPO={}", JsonUtil.getJsonFromObject(siteAddPO));
        try {
            if (StringUtils.isEmpty(siteAddPO.getFranchiserCode())){
                siteAddPO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
            }
            if (StringUtils.isEmpty(siteAddPO.getFranchiserName())){
                siteAddPO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            }
            SiteDO siteDO = SiteConverter.siteAddPO2SiteDO(siteAddPO);
            siteService.addSite(siteDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "添加投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("添加投放点信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(siteAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("添加投放点信息失败,siteAddPO={}", JsonUtil.getJsonFromObject(siteAddPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 删除投放点信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<?> deleteSite(String siteId) {
        logger.info("删除投放点信息,siteId={}", siteId);
        try {
            if (StringUtils.isNotEmpty(siteId)) {
                siteService.delSite(Long.parseLong(siteId));
            }
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "删除投放点成功");
        } catch (ZebraerpException e) {
            logger.error("删除投放点信息失败,siteId={}", siteId);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("删除投放点信息失败,siteId={},e={}", siteId, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 修改投放点信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<?> updateSite(SiteEditPO siteEditPO) {
        logger.info("修改投放点信息,siteEditPO={}", JsonUtil.getJsonFromObject(siteEditPO));
        try {
            SiteDO siteDO = SiteConverter.siteEditPO2SiteDO(siteEditPO);
            if (null == siteDO.getId() || siteDO.getId() <= 0) {
                return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "停车点ID不能为空");
            }
            siteService.editSite(siteDO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "修改投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("修改投放点信息失败,siteEditPO={}", JsonUtil.getJsonFromObject(siteEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("修改投放点信息失败,siteEditPO={}", JsonUtil.getJsonFromObject(siteEditPO));
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 解绑投放点信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/unbundle", method = RequestMethod.POST)
    public Result<?> unBindSite(@RequestParam(value = "id", required = true) Long id) {
        logger.info("解绑投放点信息,id={}", id);
        try {
            siteService.editSiteUnbind(id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "解绑投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("解绑投放点信息失败,id={}", id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("解绑投放点信息失败,id={}", id);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 捆绑投放点信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toServiceStation", method = RequestMethod.POST)
    public Result<?> bindSites(@RequestParam(value = "serviceStationId", required = true) Long serviceStationId,
                               @RequestParam(value = "siteIds", required = true) String siteIds) {
        logger.info("捆绑投放点信息,serviceStationId,siteIds={}", serviceStationId, siteIds);
        try {
            SiteBO siteBO = new SiteBO();
            siteBO.setServiceStationId(serviceStationId);
            String[] siteArr = siteIds.split(",");
            List<String> siteIdList = Arrays.asList(siteArr);
            siteBO.setSiteIdList(siteIdList);
            siteService.editSitebind(siteBO);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_SUCCESS, "捆绑投放点信息成功");
        } catch (ZebraerpException e) {
            logger.error("捆绑投放点信息失败,serviceStationId,siteIds={}", serviceStationId, siteIds);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("捆绑投放点信息失败,serviceStationId,siteIds={}", serviceStationId, siteIds);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取投放点列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<ServiceStationVO> querySiteList(@RequestParam(value = "siteName", required = false) String siteName,
                                                  @RequestParam(value = "siteId", required = false) Long siteId,
                                                  @RequestParam(value = "serviceStationName", required = false) String serviceStationName,
                                                  @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
        logger.info("获取投放点列表信息，siteName={},siteId={},serviceStationName={},pageIndex={}", siteName, siteId, serviceStationName, pageIndex);
        try {
            SiteDO siteDO = new SiteDO();
            if (StringUtils.isNotEmpty(siteName)) {
                siteDO.setSiteName(siteName);
            }
            siteDO.setId(siteId);
            siteDO.setServiceStationName(serviceStationName);
            //如果是加盟商
            if (RoleTypeEnum.FRANCHISER_TYPE.getRoleTypeCode().equals(RequestLocalInfo.getManagerRoleType())) {
                siteDO.setFranchiserCode(RequestLocalInfo.getFranchiserCode());
                siteDO.setFranchiserName(RequestLocalInfo.getFranchiserName());
            }
            siteDO.setPageIndex(pageIndex);
            List<SiteDO> listData = siteService.querySiteList(siteDO);
            Integer listCount = siteService.querySiteCount(siteDO);
            List<SiteVO> listVo = SiteConverter.siteDODO2SiteVO(listData);
            return ResultUtils.genResultWithSuccess("siteList", listVo, "count", listCount);
        } catch (ZebraerpException e) {
            logger.error("获取投放点列表信息，siteName={},siteStatus={},siteId={},serviceStationName={},pageIndex={},e={}", siteName, siteId, serviceStationName, pageIndex, e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取投放点列表信息，siteName={},siteStatus={},siteId={},serviceStationName={},pageIndex={},e={}", siteName, siteId, serviceStationName, pageIndex, e.getMessage());
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

    /**
     * 获取单个投放点信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<SiteVO> querySingleSite(@RequestParam(value = "id", required = true) Long id) {
        logger.info("获取单个投放点编号，id={}", id);
        try {
            SiteDO siteDO = siteService.querySiteByPk(id);
            SiteVO siteVO = SiteConverter.siteDODO2SiteVO(siteDO);
            return ResultUtils.genResultWithSuccess("siteDetail", siteVO);
        } catch (ZebraerpException e) {
            logger.error("获取单个投放点编号，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMsg());
        } catch (Exception e) {
            logger.error("获取单个投放点编号，id={},e", id, e);
            return ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, e.getMessage());
        }
    }

}
