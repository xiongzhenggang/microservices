package com.xzg.user.model;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("sys_role_menu_rel")
public class SysRoleMenu extends Model<SysRoleMenu> {
	public SysRoleMenu(Long roleId, Long menuId){
		this.roleId = roleId;
		this.menuId = menuId;
	}
	private Long roleId;
	private Long menuId;
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
