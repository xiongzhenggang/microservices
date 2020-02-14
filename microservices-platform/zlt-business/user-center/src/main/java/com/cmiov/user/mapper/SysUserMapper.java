package com.cmiov.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmiov.db.mapper.SuperMapper;
import com.cmiov.common.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author xzg
 * @date 2020-02-13 09:59:33
 */
public interface SysUserMapper extends SuperMapper<SysUser> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysUser> findList(Page<SysUser> page, @Param("u") Map<String, Object> params);
}
