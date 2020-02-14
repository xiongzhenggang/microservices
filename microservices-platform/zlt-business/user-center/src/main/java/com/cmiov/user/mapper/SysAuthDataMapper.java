package com.cmiov.user.mapper;

import com.cmiov.common.model.SysAuthData;
import com.cmiov.db.mapper.SuperMapper;
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
public interface SysAuthDataMapper extends SuperMapper<SysAuthData> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysAuthData> findList(Page<SysAuthData> page, @Param("p") Map<String, Object> params);
}
