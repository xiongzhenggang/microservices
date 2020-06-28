package com.xzg.framework.sys.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * @autho
 * @date 2019/7/30
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role_rel")
public class SysRoleUser extends Model<SysRoleUser> {
	public SysRoleUser(Long userId, Long roleId ){
		this.userId = userId;
		this.roleId =roleId;
	}
	private Long userId;
	private Long roleId;
	private String createUser;
	private String updateUser;
	@TableId
	private Long id;
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
	private boolean deleteFlag;
}
