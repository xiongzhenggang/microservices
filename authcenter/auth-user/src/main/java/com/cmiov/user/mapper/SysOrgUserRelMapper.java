package com.cmiov.user.mapper;

import com.cmiov.user.model.SysOrgUserRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysOrgUserRelMapper extends BaseMapper<SysOrgUserRel> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysOrgUserRel> findList(Page<SysOrgUserRel> page, @Param("p") Map<String, Object> params);
}
