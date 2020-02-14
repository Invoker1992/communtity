package com.mrh.community.mapper;

import com.mrh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/13 21:42
 **/

@Mapper
public interface UserMapper {

    @Insert("insert into user (name,accountId,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
