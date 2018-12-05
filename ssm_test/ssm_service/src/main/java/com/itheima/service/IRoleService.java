package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll(Integer page, Integer size) throws Exception;
    public void save(Role role);
    public void addPermissionToRole(@Param("roleId") String  roleId, @Param("permissionId") String[] permissionIds)throws Exception;
    public List<Permission> findOtherPermission(String roleId) throws Exception;
    Role findById(String roleId)throws Exception;
}
