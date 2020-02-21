package com.cmiov.framework.oauth.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @autho
 * 角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole  {
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
