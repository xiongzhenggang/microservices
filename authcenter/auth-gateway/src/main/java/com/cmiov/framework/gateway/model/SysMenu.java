package com.cmiov.framework.gateway.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @autho
 */
@Data
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 5412875958701291412L;
	private Long id;
	private Date createTime;
	private Date updateTime;
	private boolean deleteFlag;
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

	private List<SysMenu> subMenus;
	private Long roleId;
	private Set<Long> menuIds;
}
