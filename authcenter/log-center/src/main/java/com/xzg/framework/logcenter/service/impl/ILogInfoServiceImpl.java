package com.xzg.framework.logcenter.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.framework.logcenter.dto.AuditLogDto;
import com.xzg.framework.logcenter.entity.LogInfo;
import com.xzg.framework.logcenter.mapper.LogInfoMapper;
import com.xzg.framework.logcenter.model.PageResult;
import com.xzg.framework.logcenter.model.Result;
import org.apache.commons.collections4.MapUtils;
import com.xzg.framework.logcenter.service.ILogInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author xzg
 */
@Service
public class ILogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo>  implements ILogInfoService {
    @Override
    public PageResult<LogInfo> searchAuditLog(Map<String, Object> params) {
        Page<LogInfo> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<LogInfo> list  =  baseMapper.findList(page, params);
        return PageResult.<LogInfo>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public Result<String> saveAuditLog(AuditLogDto dto) {
        LogInfo logInfo = new LogInfo();
        BeanUtils.copyProperties(dto,logInfo);
        logInfo.setCreateTime(LocalDateTime.now());
        baseMapper.insert(logInfo);
        return Result.succeed();
    }
}
