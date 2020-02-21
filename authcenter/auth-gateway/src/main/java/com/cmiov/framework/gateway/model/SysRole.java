package com.cmiov.framework.gateway.model;

import lombok.Data;

import java.util.Date;

/**
 * @autho
 * 角色
 */
@Data
public class SysRole   {
    private static final long serialVersionUID = 4497149010220586231L;
    private Long id;
    private Date createTime;
    private Date updateTime;
    private boolean deleteFlag;
    private String code;
    private String name;
    private String createUser;
    private String updateUser;
    private String type;
    private String tenantId;
    private Long userId;
}
