package com.niu.dao;

import com.niu.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ami on 2018/11/20.
 */
@Mapper
public interface UserDao {
    @Select("SELECT * FROM USERINFO WHERE username = #{username}")
    UserInfo findByName(@Param("username") String username);

    @Insert("INSERT INTO USERINFO(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String name, @Param("password") String password);



}
