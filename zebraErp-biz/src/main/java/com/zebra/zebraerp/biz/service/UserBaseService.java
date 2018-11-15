package com.zebra.zebraerp.biz.service;

import java.util.List;


import com.zebra.zebraerp.dal.dataobject.UserBaseDO;
import com.zebra.zebraerp.dal.dataobject.UserConsumeDO;

/**
 * 用户基础表Service
 *
 * @author
 * @ClassName: UserBaseService
 * @Description: by CodeGenerate
 */
public interface UserBaseService {

    /**
     * 查询用户消费列表
     *
     * @param userConsumeDO
     * @return
     */
    List<UserConsumeDO> queryUserConsumeList(UserConsumeDO userConsumeDO);

    /**
     * 查询用户消费列表数量
     * @param userConsumeDO
     * @return
     */
    Integer queryUserConsumeCount(UserConsumeDO userConsumeDO);

    /**
     * 根据id查询
     *
     * @param uid
     * @return
     */
    UserBaseDO queryUserBaseById(long uid);

    /**
     * 分页查询
     *
     * @param userBaseDO
     * @return
     */
    List<UserBaseDO> queryUserBaseByPage(UserBaseDO userBaseDO);

    /**
     * 查询列表
     *
     * @param userBaseDO
     * @return
     */
    List<UserBaseDO> queryUserBaseList(UserBaseDO userBaseDO);

    /**
     * 创建
     *
     * @param userBaseDO
     * @return
     */
    void createUserBase(UserBaseDO userBaseDO);

    /**
     * 修改
     *
     * @param userBaseDO
     * @return
     */
    int modifyUserBase(UserBaseDO userBaseDO);

    /**
     * 选择性修改
     *
     * @param userBaseDO
     * @return
     */
    int modifyUserBaseSelective(UserBaseDO userBaseDO);

    /**
     * 删除
     *
     * @param uid
     * @return
     */
    int removeUserBase(long uid);

}