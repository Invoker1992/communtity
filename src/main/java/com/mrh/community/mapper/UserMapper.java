package com.mrh.community.mapper;

import com.mrh.community.model.User;
import org.apache.el.parser.Token;
import org.apache.ibatis.annotations.*;

import javax.naming.Name;


/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/13 21:42
 **/

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER (name,account_Id,token,gmt_create,gmt_modified,avatar_url) VALUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId")String accountId);

    @Update("update user set name = #{name},token=#{token},gmt_modified = #{gmtModified},avatar_url=#{avatarUrl} where account_id = #{accountId}")
    void update(User user);
}
