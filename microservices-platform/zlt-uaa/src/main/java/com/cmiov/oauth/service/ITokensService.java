package com.cmiov.oauth.service;

import com.cmiov.common.model.PageResult;
import com.cmiov.oauth.model.TokenVo;

import java.util.Map;

/**
 * @autho
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
