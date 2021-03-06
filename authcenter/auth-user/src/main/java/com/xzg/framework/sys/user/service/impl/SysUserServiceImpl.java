package com.xzg.framework.sys.user.service.impl;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.commonentity.SuperEntity;
import com.xzg.framework.sys.constant.CommonConstant;
import com.xzg.framework.sys.organ.entity.SysOrg;
import com.xzg.framework.sys.organ.entity.SysOrgUserRel;
import com.xzg.framework.sys.organ.mapper.SysOrgUserRelMapper;
import com.xzg.framework.sys.menu.entity.SysMenu;
import com.xzg.framework.sys.role.entity.SysRole;
import com.xzg.framework.sys.role.mapper.SysRoleMenuMapper;
import com.xzg.framework.sys.user.entity.SysRoleUser;
import com.xzg.framework.sys.user.entity.SysUser;
import com.xzg.framework.sys.user.mapper.SysUserMapper;
import com.xzg.framework.sys.user.service.ISysRoleUserService;
import com.xzg.framework.sys.user.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.framework.sys.user.dto.LoginAppUser;
import com.xzg.framework.sys.user.dto.SysUserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISysRoleUserService roleUserService;

    @Resource
    private SysRoleMenuMapper roleMenuMapper;

    @Resource
    private SysOrgUserRelMapper orgUserMapper;

    @Override
    public LoginAppUser findByUsername(String username) {
        SysUserDto sysUser = this.selectByUsername(username);
        return getLoginAppUser(sysUser);
    }

    @Override
    public LoginAppUser findByOpenId(String username) {
        SysUserDto sysUser = this.selectByOpenId(username);
        return getLoginAppUser(sysUser);
    }

    @Override
    public LoginAppUser findByMobile(String username) {
        SysUserDto sysUser = this.selectByMobile(username);
        return getLoginAppUser(sysUser);
    }

    @Override
    public LoginAppUser getLoginAppUser(SysUserDto sysUser) {
        if (sysUser != null) {
            LoginAppUser loginAppUser = new LoginAppUser();
            BeanUtils.copyProperties(sysUser, loginAppUser);
            List<SysRole> sysRoles = roleUserService.findRolesByUserId(sysUser.getId());
            // 设置角色
            loginAppUser.setRoles(sysRoles);

            if (!CollectionUtils.isEmpty(sysRoles)) {
                Set<Long> roleIds = sysRoles.parallelStream().map(SuperEntity::getId).collect(Collectors.toSet());
                List<SysMenu> menus = roleMenuMapper.findMenusByRoleIds(roleIds, CommonConstant.MENU_RESOURCE);
                if (!CollectionUtils.isEmpty(menus)) {
                    Set<String> permissions = menus.parallelStream().map(p -> p.getUrl())
                            .collect(Collectors.toSet());
                    // 设置权限集合
                    loginAppUser.setPermissions(permissions);
                }
            }
            return loginAppUser;
        }
        return null;
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public SysUserDto selectByUsername(String username) {
        List<SysUser> users = baseMapper.selectList(
                new QueryWrapper<SysUser>().eq("user_name", username)
        );
        return getUser(users);
    }

    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    @Override
    public SysUserDto selectByMobile(String mobile) {
        List<SysUser> users = baseMapper.selectList(
                new QueryWrapper<SysUser>().eq("mobile", mobile)
        );
        return getUser(users);
    }

    /**
     * 根据openId查询用户
     * @param openId
     * @return
     */
    @Override
    public SysUserDto selectByOpenId(String openId) {
        List<SysUser> users = baseMapper.selectList(
                new QueryWrapper<SysUser>().eq("open_id", openId)
        );
        return getUser(users);
    }

    private SysUserDto getUser(List<SysUser> users) {
        SysUserDto user = null;
        if (users != null && !users.isEmpty()) {
            user = new SysUserDto();
            //设置组织机构
            BeanUtils.copyProperties(users.get(0),user);
            SysOrg org =  orgUserMapper.findOrganByUserId(user.getId());
            user.setOrgId(org.getId());
            user.setOrgName(org.getName());
        }
        return user;
    }

    /**
     * 给用户设置角色
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void setRoleToUser(Long id, Set<Long> roleIds) {
        SysUser sysUser = baseMapper.selectById(id);
        if (sysUser == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        roleUserService.deleteUserRole(id, null);
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<SysRoleUser> roleUsers = new ArrayList<>(roleIds.size());
            roleIds.forEach(roleId -> roleUsers.add(new SysRoleUser(id, roleId)));
            roleUserService.saveBatch(roleUsers);
        }
    }

    @Transactional
    @Override
    public Result updatePassword(Long id, String oldPassword, String newPassword) {
        SysUser sysUser = baseMapper.selectById(id);
        if (StringUtils.isNotBlank(oldPassword)) {
            if (!passwordEncoder.matches(oldPassword, sysUser.getPassword())) {
                return Result.failed("旧密码错误");
            }
        }
        if (StringUtils.isBlank(newPassword)) {
            newPassword = CommonConstant.DEF_USER_PASSWORD;
        }
        SysUser user = new SysUser();
        user.setId(id);
        baseMapper.updateById(user);
        user.setPassword(passwordEncoder.encode(newPassword));
        return Result.succeed("修改成功");
    }

    @Override
    public PageResult<SysUser> findUsers(Map<String, Object> params) {
        Page<SysUser> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysUser> list = baseMapper.findList(page, params);
        long total = page.getTotal();
        if (total > 0) {
            List<Long> userIds = list.stream().map(SysUser::getId).collect(Collectors.toList());

            List<SysRole> sysRoles = roleUserService.findRolesByUserIds(userIds);
            list.forEach(u ->{
                u.setRoles(sysRoles.stream().filter(r -> !ObjectUtils.notEqual(u.getId(), r.getUserId()))
                    .collect(Collectors.toList()));
                    u.setPassword(null);
            });
        }
        return PageResult.<SysUser>builder().data(list).code(0).count(total).build();
    }

    @Override
    public List<SysRole> findRolesByUserId(Long userId) {
        return roleUserService.findRolesByUserId(userId);
    }

    @Override
    public Result updateEnabled(Map<String, Object> params) {
        Long id = MapUtils.getLong(params, "id");
        Boolean enabled = MapUtils.getBoolean(params, "enabled");

        SysUser appUser = baseMapper.selectById(id);
        if (appUser == null) {
            return Result.failed("用户不存在");
        }
        appUser.setEnabled(enabled);
        appUser.setUpdateTime(new Date());

        int i = baseMapper.updateById(appUser);
        log.info("修改用户：{}", appUser);

        return i > 0 ? Result.succeed(appUser, "更新成功") : Result.failed("更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result saveOrUpdateUser(SysUser sysUser,SysUserDto currentUser) {
        if (Objects.isNull(sysUser.getId())) {
            if (StringUtils.isBlank(sysUser.getType())) {
                sysUser.setType(CommonConstant.DEF_USER_TYPE);
            }
            sysUser.setCreateUser(currentUser.getUserName());
            sysUser.setPassword(passwordEncoder.encode(CommonConstant.DEF_USER_PASSWORD));
            sysUser.setEnabled(Boolean.TRUE);
        }else{
            //更新角色
            if (StringUtils.isNotEmpty(sysUser.getRoleId())) {
                roleUserService.deleteUserRole(sysUser.getId(), null);
                List roleIds = Arrays.asList(sysUser.getRoleId().split(","));
                if (!CollectionUtils.isEmpty(roleIds)) {
                    List<SysRoleUser> roleUsers = new ArrayList<>(roleIds.size());
                    roleIds.forEach(roleId -> roleUsers.add(new SysRoleUser(sysUser.getId(), Long.parseLong(roleId.toString()))));
                    roleUserService.saveBatch(roleUsers);
                }
            }
        }
        super.save(sysUser);
        //保存用户组织机构关联表
        SysOrgUserRel sour = new SysOrgUserRel();
        sour.setOrgId(currentUser.getOrgId());
        sour.setUserId(sysUser.getId());
        orgUserMapper.insert(sour);
        return Result.succeed("操作成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delUser(Long id) {
        //删除关联的角色
        roleUserService.deleteUserRole(id, null);
        //删除用户
        return baseMapper.deleteById(id) > 0;
    }

}