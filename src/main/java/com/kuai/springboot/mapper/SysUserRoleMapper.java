package com.kuai.springboot.mapper;

import com.kuai.springboot.domain.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRole key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}