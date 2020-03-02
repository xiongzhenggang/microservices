package com.cmiov.framework.logcenter.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import  com.cmiov.framework.logcenter.entity.LogInfo;
/**
*  @author author
*/
public interface LogInfoMapper extends BaseMapper<LogInfo> {
        /**
         * 分页查询用户列表
         * @param page
         * @param params
         * @return
         */
        List<LogInfo> findList(Page<LogInfo> page, @Param("u") Map<String, Object> params);
}
