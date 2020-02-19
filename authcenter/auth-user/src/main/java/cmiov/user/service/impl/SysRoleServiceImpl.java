package cmiov.user.service.impl;

import cmiov.user.mapper.SysRoleMapper;
import cmiov.user.mapper.SysRoleMenuMapper;
import cmiov.user.mapper.SysUserRoleMapper;
import cmiov.user.model.PageResult;
import cmiov.user.model.Result;
import cmiov.user.model.SysRole;
import cmiov.user.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Resource
    private SysRoleMenuMapper roleMenuMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRole(SysRole sysRole) {
        super.save(sysRole);
//        super.saveIdempotency(sysRole, lock
//                , LOCK_KEY_ROLECODE+roleCode, new QueryWrapper<SysRole>().eq("code", roleCode), "角色code已存在");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(Long id) {
        baseMapper.deleteById(id);
        roleMenuMapper.delete(id, null);
        userRoleMapper.deleteUserRole(null, id);
    }

    @Override
    public PageResult<SysRole> findRoles(Map<String, Object> params) {
        Integer curPage = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        Page<SysRole> page = new Page<>(curPage == null ? 0 : curPage, limit == null ? -1 : limit);
        List<SysRole> list = baseMapper.findList(page, params);
        return PageResult.<SysRole>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    @Transactional
    public Result saveOrUpdateRole(SysRole sysRole) {
        if (sysRole.getId() == null) {
            this.saveRole(sysRole);
        } else {
            baseMapper.updateById(sysRole);
        }
        return Result.succeed("操作成功");
    }

    @Override
    public List<SysRole> findAll() {
        return baseMapper.findAll();
    }
}
