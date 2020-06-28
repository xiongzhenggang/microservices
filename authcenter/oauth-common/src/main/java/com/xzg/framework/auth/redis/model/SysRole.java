package com.xzg.framework.auth.redis.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xzg
 * @autho
 * 角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole implements Serializable {
    private static final long serialVersionUID = -1292627314915340121L;
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
