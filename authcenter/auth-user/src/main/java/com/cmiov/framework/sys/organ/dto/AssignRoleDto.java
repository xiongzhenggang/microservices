package com.cmiov.framework.sys.organ.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author xzg
 */
@Data
public class AssignRoleDto {
    private Long orgId;
    private Set<Long> roles;
}
