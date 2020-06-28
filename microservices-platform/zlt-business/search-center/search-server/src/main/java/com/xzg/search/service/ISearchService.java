package com.xzg.search.service;

import com.alibaba.fastjson.JSONObject;
import com.xzg.common.model.PageResult;
import com.xzg.search.model.SearchDto;

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
