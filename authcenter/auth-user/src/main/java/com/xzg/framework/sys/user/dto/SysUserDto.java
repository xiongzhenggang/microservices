package com.xzg.framework.sys.user.dto;

import com.xzg.framework.sys.role.entity.SysRole;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 *
 *
 * @author xzg
 * @date 2020-02-13 09:59:33
 */
@Data
public class SysUserDto {

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
	private Long orgId;
	private String orgName;
	private String roleId;
	private String oldPassword;
	private String newPassword;
}
