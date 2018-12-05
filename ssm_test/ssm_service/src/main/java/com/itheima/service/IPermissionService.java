package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface IPermissionService  {
    public List<Permission> findAll(Integer page, Integer size) throws Exception;
    public void save(Permission p) throws Exception;
}
