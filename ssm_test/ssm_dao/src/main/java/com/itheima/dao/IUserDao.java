package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    //根据名称查询用户
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(column ="status",property ="status"),
            @Result(column = "id",property = "roles",many =@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username)throws Exception;

    //查询所有用户
    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;

    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;


    //根据id查询用户
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(column ="status",property ="status"),
            @Result(column = "id",property = "roles",many = @Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId)throws Exception;

    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    public List<Role> findOtherRole(String userId) throws Exception;
}
