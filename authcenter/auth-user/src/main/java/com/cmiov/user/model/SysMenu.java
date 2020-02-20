package com.cmiov.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * @autho
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenu extends SuperEntity {
	private static final long serialVersionUID = 749360940290141180L;

	private Long parentId;
	private String name;
	private String menuRoute;
	private String url;
	private String icon;
	private Integer sort;
	private String type;
	private String describe;
	private String createUser;
	private String updateUser;
	private String tenantId;
	/**
	 * 请求的类型
	 */
	private String method;

	@TableField(exist = false)
	private List<SysMenu> subMenus;
	@TableField(exist = false)
	private Long roleId;
	@TableField(exist = false)
	private Set<Long> menuIds;
}
