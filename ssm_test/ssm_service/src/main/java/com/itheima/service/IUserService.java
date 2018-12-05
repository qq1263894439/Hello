package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer size)throws Exception;
    void save(UserInfo user) throws Exception;
    UserInfo findById(String id) throws Exception;
    public List<Role> findOtherRole(String userId)throws Exception;
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String[] roleId)throws Exception;


}
