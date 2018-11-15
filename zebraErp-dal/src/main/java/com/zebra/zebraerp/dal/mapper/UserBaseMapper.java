package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import com.zebra.zebraerp.dal.dataobject.UserConsumeDO;
import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.UserBaseDO;

/**
 * 用户基础表MAPPER
 * 
 * @ClassName: UserBaseMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface UserBaseMapper {

	/** 添加 */
	int insertUserBase(UserBaseDO userBaseDO);

	/** 根据主键查询 */
	UserBaseDO selectUserBaseById(Long uid);

	/** 查询列表 */
	List<UserBaseDO> selectUserBaseList(UserBaseDO userBaseDO);

	List<UserConsumeDO> selectUserConsumeList(UserConsumeDO userConsumeDO);

	Integer selectUserConsumeCount(UserConsumeDO userConsumeDO);

	/** 分页计数 */
	public int selectUserBaseCount(UserBaseDO userBaseDO);
	
	/** 分页查找 */
	public List<UserBaseDO> selectUserBasePage(UserBaseDO userBaseDO);

	/** 完全修改 */
	public int updateUserBase(UserBaseDO userBaseDO);

	/** 选择性修改 */
	public int updateUserBaseSelective(UserBaseDO userBaseDO);

	/** 删除 */
	public int deleteUserBase(Long uid);
}