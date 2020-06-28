package com.xzg.framework.sys.organ.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.framework.sys.commonentity.SuperEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org")
public class SysOrg extends SuperEntity {
    private static final long serialVersionUID=1L;

        private Long parentId;
        private String name;
        private String icon;
        private Integer sort;
        private String type;
        private String describe;
        private String createUser;
        private String updateUser;
    }
