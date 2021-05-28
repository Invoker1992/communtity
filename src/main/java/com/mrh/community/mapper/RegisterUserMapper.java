package com.mrh.community.mapper;

import com.mrh.community.dto.RegisterUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterUserMapper {

    /**
     * 注册用户
     * @param username
     * @param password
     * @param avatarUrl
     */
    @Insert("insert into registerUser (username,password,avatarUrl) values (#{username},#{password},#{avatarUrl})")
    void registerUser(String username,String password,String avatarUrl);

    /**
     * 判断账号密码是否正确
     * @param username
     * @param password
     * @return
     */
    @Select("select * from registerUser where username = #{username} and password = #{password}")
    RegisterUserDTO loginCheckStatus(String username,String password);

    /**
     * 防止用户名重复注册
     */
    @Select("select count(*) from registerUser where username = #{username}")
    int getUserNameNum(String username);
}
