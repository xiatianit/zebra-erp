package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.FranchiserBaseDO;

/**
 * 加盟商基础信息表Service
 *
 * @author
 * @ClassName: FranchiserBaseService
 * @Description: by CodeGenerate
 */
public interface FranchiserBaseService {



    /**
     * 根据id查询
     *
     * @param franchiserCode
     * @return
     */
    FranchiserBaseDO queryFranchiserBaseById(String franchiserCode);

    /**
     * 分页技术
     *
     * @param franchiserBaseDO
     * @return
     */
    int queryFranchiserBaseCount(FranchiserBaseDO franchiserBaseDO);

    /**
     * 分页查询
     *
     * @param franchiserBaseDO
     * @return
     */
    List<FranchiserBaseDO> queryFranchiserBaseByPage(FranchiserBaseDO franchiserBaseDO);

    /**
     * 查询列表
     *
     * @param franchiserBaseDO
     * @return
     */
    List<FranchiserBaseDO> queryFranchiserBaseList(FranchiserBaseDO franchiserBaseDO);

    /**
     * 添加加盟商及其ERP管理人员账号
     * @param franchiserBaseDO
     */
    void addFranchiser(FranchiserBaseDO franchiserBaseDO);

    /**
     * 创建
     *
     * @param franchiserBaseDO
     * @return
     */
    void createFranchiserBase(FranchiserBaseDO franchiserBaseDO);

    /**
     * 修改
     *
     * @param franchiserBaseDO
     * @return
     */
    int modifyFranchiserBase(FranchiserBaseDO franchiserBaseDO);

    /**
     * 选择性修改
     *
     * @param franchiserBaseDO
     * @return
     */
    int modifyFranchiserBaseSelective(FranchiserBaseDO franchiserBaseDO);

    /**
     * 删除
     *
     * @param franchiserCode
     * @return
     */
    void removeFranchiserBase(String franchiserCode);

}