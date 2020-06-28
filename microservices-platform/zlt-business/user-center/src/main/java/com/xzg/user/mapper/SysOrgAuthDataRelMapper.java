package com.xzg.user.mapper;

import com.xzg.user.model.SysOrgAuthDataRel;
import com.xzg.db.mapper.SuperMapper;
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
public interface SysOrgAuthDataRelMapper extends SuperMapper<SysOrgAuthDataRel> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysOrgAuthDataRel> findList(Page<SysOrgAuthDataRel> page, @Param("p") Map<String, Object> params);
}
