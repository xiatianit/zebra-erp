package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.ProvinceDO;

/**
 * 省份信息表MAPPER
 * 
 * @ClassName: ProvinceMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface ProvinceMapper {

	/** 添加 */
	 int insertProvince(ProvinceDO provinceDO);

	/** 根据主键查询 */
	public ProvinceDO selectProvinceById(String provinceCode);

	/** 查询列表 */
	public List<ProvinceDO> selectProvinceList(ProvinceDO provinceDO);
	
	/** 分页计数 */
	public int selectProvinceCount(ProvinceDO provinceDO);
	
	/** 分页查找 */
	public List<ProvinceDO> selectProvincePage(ProvinceDO provinceDO);

	/** 完全修改 */
	public int updateProvince(ProvinceDO provinceDO);

	/** 选择性修改 */
	public int updateProvinceSelective(ProvinceDO provinceDO);

	/** 删除 */
	public int deleteProvince(String provinceCode);
}