package com.mrh.community.mapper;

import com.mrh.community.model.User;
import org.apache.el.parser.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.naming.Name;


/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/13 21:42
 **/

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER (name,account_Id,token,gmt_create,gmt_modified) VALUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
