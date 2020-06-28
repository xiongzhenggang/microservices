package com.xzg.user.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.db.mapper.SuperMapper;

import com.xzg.common.model.SysRole;
import org.apache.ibatis.annotations.Param;

/**
* @autho
 * 角色
 */
public interface SysRoleMapper extends SuperMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

	List<SysRole> findAll();
}
