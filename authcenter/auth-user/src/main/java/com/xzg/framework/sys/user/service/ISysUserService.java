package com.xzg.framework.sys.user.service;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.user.dto.LoginAppUser;
import com.xzg.framework.sys.role.entity.SysRole;
import com.xzg.framework.sys.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.framework.sys.user.dto.SysUserDto;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @autho
 */
public interface ISysUserService extends IService<SysUser> {
	/**
	 * 获取UserDetails对象
	 * @param username
	 * @return
	 */
	LoginAppUser findByUsername(String username);

	LoginAppUser findByOpenId(String username);

	LoginAppUser findByMobile(String username);

	/**
	 * 通过SysUser 转换为 LoginAppUser，把roles和permissions也查询出来
	 * @param sysUser
	 * @return
	 */
	LoginAppUser getLoginAppUser(SysUserDto sysUser);

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	SysUserDto selectByUsername(String username);
	/**
	 * 根据手机号查询用户
	 * @param mobile
	 * @return
	 */
	SysUserDto selectByMobile(String mobile);
	/**
	 * 根据openId查询用户
	 * @param openId
	 * @return
	 */
	SysUserDto selectByOpenId(String openId);

	/**
	 * 用户分配角色
	 * @param id
	 * @param roleIds
	 */
	void setRoleToUser(Long id, Set<Long> roleIds);

	/**
	 * 更新密码
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	Result updatePassword(Long id, String oldPassword, String newPassword);

	/**
	 * 用户列表
	 * @param params
	 * @return
	 */
	PageResult<SysUser> findUsers(Map<String, Object> params);


	/**
	 * 用户角色列表
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Long userId);

	/**
	 * 状态变更
	 * @param params
	 * @return
	 */
	Result updateEnabled(Map<String, Object> params);


	Result saveOrUpdateUser(SysUser sysUser,SysUserDto currentUser);

	/**
	 * 删除用户
	 */
	boolean delUser(Long id);
}
