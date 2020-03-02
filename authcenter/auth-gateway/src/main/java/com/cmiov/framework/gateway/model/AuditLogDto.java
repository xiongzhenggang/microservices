package com.cmiov.framework.gateway.model;

import lombok.Data;

@Data
public class AuditLogDto {

    private String descName;

    /**
     * 用户ID
     * isNullAble:1
     */
    private Integer userId;

    /**
     * 用户姓名
     * isNullAble:0
     */
    private String userName;

    /**
     * 组织机构ID
     * isNullAble:1
     */
    private Integer orgId;

    /**
     * ip地址
     * isNullAble:1
     */
    private String ipAddress;

    /**
     * 浏览器信息
     * isNullAble:1
     */
    private String browserInfo;

    /**
     * 请求地址信息
     * isNullAble:1
     */
    private String resourceUrl;

    /**
     * 操作类型 resource：资源 menue 菜单
     * isNullAble:1
     */
    private String type;

    /**
     * 请求方法
     * isNullAble:1
     */
    private String methondType;

}
