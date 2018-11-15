package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.FranchiserSettlementDO;

/**
 * 加盟商结算申请表Service
 *
 * @author
 * @ClassName: FranchiserSettlementService
 * @Description: by CodeGenerate
 */
public interface FranchiserSettlementService {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    FranchiserSettlementDO queryFranchiserSettlementById(long id);

    /**
     * 分页查询
     *
     * @param franchiserSettlementDO
     * @return
     */
    List<FranchiserSettlementDO> queryFranchiserSettlementByPage(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 查询加盟商申请结算数量
     *
     * @param franchiserSettlementDO
     * @return
     */
    Integer queryFranchiserSettlementCount(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 查询列表
     *
     * @param franchiserSettlementDO
     * @return
     */
    List<FranchiserSettlementDO> queryFranchiserSettlementList(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 创建
     *
     * @param franchiserSettlementDO
     * @return
     */
    void createFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 修改
     *
     * @param franchiserSettlementDO
     * @return
     */
    int modifyFranchiserSettlement(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 选择性修改
     *
     * @param franchiserSettlementDO
     * @return
     */
    int modifyFranchiserSettlementSelective(FranchiserSettlementDO franchiserSettlementDO);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int removeFranchiserSettlement(long id);

    /**
     * 加盟商申请结算
     * @param franchiserCode
     * @param appyTime
     */
    void franchiserSettlementApply(String franchiserCode,String franchiserName,Integer appyTime);

}