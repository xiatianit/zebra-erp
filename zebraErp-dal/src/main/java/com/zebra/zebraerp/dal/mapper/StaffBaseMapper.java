package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.StaffBaseDO;

public interface StaffBaseMapper {

    /****************** 基础的增删改查 ********************/
    /**
     * 查询
     *
     * @param
     * @return
     */
    StaffBaseDO selectByPk(@Param("sid") Long sid);

    /**
     * 插入
     *
     * @param staffBaseDO
     * @return
     */
    int insert(StaffBaseDO staffBaseDO);

    /**
     * 更新
     *
     * @param staffBaseDO
     * @return
     */
    int update(StaffBaseDO staffBaseDO);

    /**
     * 删除
     * @param sid
     * @return
     */
    int delete(Long sid);

    /**
     * 获取服务员工基本信息
     * 
     * @param
     * @return
     */
    List<StaffBaseDO> selectByCondition(StaffBaseDO staffBaseDO);

    /**
     * 获取服务员工基本信息个数
     * 
     * @param
     * @return
     */
    int selectCountByCondition(StaffBaseDO staffBaseDO);

}
