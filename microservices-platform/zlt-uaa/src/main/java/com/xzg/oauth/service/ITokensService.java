package com.xzg.oauth.service;

import com.xzg.common.model.PageResult;
import com.xzg.oauth.model.TokenVo;

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
