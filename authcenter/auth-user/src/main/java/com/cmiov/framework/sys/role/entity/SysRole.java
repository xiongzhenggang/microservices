package com.cmiov.framework.sys.role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cmiov.framework.sys.commonentity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @autho
 * 角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole extends SuperEntity {
    private static final long serialVersionUID = 4497149010220586111L;
    private String code;
    private String name;
    private String createUser;
    private String updateUser;
    private String type;
    private String tenantId;
    private Long userId;
}
