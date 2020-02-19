package cmiov.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 *
 *
 * @author xzg
 * @date 2020-02-13 09:59:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUser extends SuperEntity {
	private static final long serialVersionUID = -5886012896705137070L;


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

	@TableField(exist = false)
	private List<SysRole> roles;
	@TableField(exist = false)
	private String roleId;
	@TableField(exist = false)
	private String oldPassword;
	@TableField(exist = false)
	private String newPassword;
}
