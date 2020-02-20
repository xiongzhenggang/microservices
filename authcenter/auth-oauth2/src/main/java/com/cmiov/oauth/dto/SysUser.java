package com.cmiov.oauth.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *
 *
 * @author xzg
 * @date 2020-02-13 09:59:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser  {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private boolean deleteFlag;
	private String userName;
	private String mobile;
	private String password;
	private String email;
	private String nickName;
	private String photo;
	private Boolean enabled;
	private String type;
	private String createUser;
	private String updateUser;
	private String openId;

	private List<SysRole> roles;
	private String roleId;
	private String oldPassword;
	private String newPassword;
}
