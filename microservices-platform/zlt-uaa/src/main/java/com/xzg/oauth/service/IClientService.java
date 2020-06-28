package com.xzg.oauth.service;

import com.xzg.common.model.PageResult;
import com.xzg.common.model.Result;
import com.xzg.common.service.ISuperService;
import com.xzg.oauth.model.Client;

import java.util.Map;

/**
 * @autho
 */
public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto);

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClent(Map<String, Object> params, boolean isPage);

    void delClient(long id);
}
