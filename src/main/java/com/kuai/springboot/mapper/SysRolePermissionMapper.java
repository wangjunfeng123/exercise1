package com.kuai.springboot.mapper;

import com.kuai.springboot.domain.SysRolePermission;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}