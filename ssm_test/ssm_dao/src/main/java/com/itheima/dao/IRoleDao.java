package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

   @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
   @Results({
           @Result(id = true, property = "id", column = "id"),
           @Result(property = "roleName", column = "roleName"),
           @Result(property = "roleDesc", column = "roleDesc"),
           @Result(property = "permissions",column = "id",many = @Many(select = "com.itheima.dao.IPermissionDao.findPermissionByRoleId"))
   })
   public  List<Role> findRoleByUserId(String userId) throws Exception;

   @Select("select * from role")
   public  List<Role> findAll() throws Exception;

   @Select("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);

   @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
   public List<Permission> findOtherPermission(String roleId) throws Exception;

   @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId}))")
   public void addPermissionToRole(@Param("roleId") String  roleId, @Param("permissionId") String[] permissionIds)throws Exception;

   @Select("select * from role where id=#{roleId}")
   @Results({
           @Result(id = true,property = "id",column = "id"),
           @Result(property = "roleName",column = "roleName"),
           @Result(property = "roleDesc",column = "roleDesc"),
           @Result(property = "permissions",column = "id",many = @Many(select = "com.itheima.dao.IPermissionDao.findPermissionByRoleId"))
   })
   Role findById(String roleId)throws Exception;
}
