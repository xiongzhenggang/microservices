package com.cmiov.framework.logcenter.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author xzg
 * @date
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchDto  implements Serializable {
    private static final long serialVersionUID = -6002235560999046088L;
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