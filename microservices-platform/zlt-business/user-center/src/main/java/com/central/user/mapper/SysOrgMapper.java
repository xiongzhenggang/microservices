package com.central.user.mapper;

import com.central.common.model.SysOrg;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface SysOrgMapper extends SuperMapper<SysOrg> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysOrg> findList(Page<SysOrg> page, @Param("p") Map<String, Object> params);
}
