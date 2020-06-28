package com.xzg.framework.search.client.service;

import com.alibaba.fastjson.JSONObject;
import com.xzg.framework.search.client.dto.SearchDto;
import com.xzg.framework.search.common.model.PageResult;

/**
 * @autho
 * @date 2019/4/24
 */
public interface ISearchService {
    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    PageResult<JSONObject> strQuery(String indexName, SearchDto searchDto);


}
