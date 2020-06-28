package com.xzg.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_auth_data")
public class SysAuthData extends SuperEntity {
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
