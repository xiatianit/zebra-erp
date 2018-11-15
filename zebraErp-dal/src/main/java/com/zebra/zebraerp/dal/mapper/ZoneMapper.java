package com.zebra.zebraerp.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zebra.zebraerp.dal.dataobject.ZoneDO;

/**
 * 区域信息表MAPPER
 * 
 * @ClassName: ZoneMapper
 * @Description: by CodeGenerate
 * @author 
 * 
 */

public interface ZoneMapper {

	/** 添加 */
	public int insertZone(ZoneDO zoneDO);

	/** 根据主键查询 */
	public ZoneDO selectZoneById(String zoneCode);

	/** 查询列表 */
	public List<ZoneDO> selectZoneList(ZoneDO zoneDO);
	
	/** 分页计数 */
	public int selectZoneCount(ZoneDO zoneDO);
	
	/** 分页查找 */
	public List<ZoneDO> selectZonePage(ZoneDO zoneDO);

	/** 完全修改 */
	public int updateZone(ZoneDO zoneDO);

	/** 选择性修改 */
	public int updateZoneSelective(ZoneDO zoneDO);

	/** 删除 */
	public int deleteZone(String zoneCode);
}