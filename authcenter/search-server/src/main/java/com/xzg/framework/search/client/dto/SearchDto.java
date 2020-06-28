package com.xzg.framework.search.client.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @autho
 * @date 2020/3/5
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchDto implements Serializable {
    private static final long serialVersionUID = -6501257016600685017L;
    /**
     * 搜索关键字
     */
    private String queryStr;
    /**
     * 当前页数
     */
    private Integer page;
    /**
     * 每页显示数
     */
    private Integer limit;
    /**
     * 排序字段
     */
    private String sortCol;
    /**
     * 是否显示高亮
     */
    private Boolean isHighlighter;
    /**
     * es的路由
     */
    private String routing;
}
