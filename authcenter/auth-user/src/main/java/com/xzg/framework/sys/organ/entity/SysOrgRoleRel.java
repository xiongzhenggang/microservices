package com.xzg.framework.sys.organ.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org_role_rel")
public class SysOrgRoleRel extends Model<SysOrgRoleRel> {
    private static final long serialVersionUID=1L;
        @TableId
        private Long id;
        private Long orgId;
        private Long roleId;
        private String createUser;
        private String updateUser;
        @TableField(fill = FieldFill.INSERT)
        private Date createTime;
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private Date updateTime;
        private boolean deleteFlag;
    }
