package com.xzg.framework.sys.user.dto;

import lombok.Data;



/**
 *
 *
 * @author xzg
 * @date 2020-02-26 09:59:33
 */
@Data
public class UserPasswordDto {

	private Long userId;
	private String oldPassword;
	private String newPassword;
}
