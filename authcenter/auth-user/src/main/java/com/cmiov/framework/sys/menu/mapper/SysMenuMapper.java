package com.cmiov.framework.sys.menu.mapper;

import com.cmiov.framework.sys.menu.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 菜单
 *
 * @autho
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> findAll();

}
