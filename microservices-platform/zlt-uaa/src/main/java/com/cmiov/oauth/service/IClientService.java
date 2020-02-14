package com.cmiov.oauth.service;

import com.cmiov.common.model.PageResult;
import com.cmiov.common.model.Result;
import com.cmiov.common.service.ISuperService;
import com.cmiov.oauth.model.Client;

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
