package cmiov.user.service;

import cmiov.user.model.PageResult;
import cmiov.user.model.SysOrg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface ISysOrgService extends IService<SysOrg> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysOrg> findList(Map<String, Object> params);
}

