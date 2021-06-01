package com.mrh.community.service;

import com.mrh.community.dto.QuestionDTO;
import com.mrh.community.mapper.UserExtMapper;
import com.mrh.community.mapper.UserMapper;
import com.mrh.community.model.Question;
import com.mrh.community.model.User;
import com.mrh.community.model.UserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/27 16:33
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(user.getName());  //因为注册的时候名子是不允许重复的
//                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==0)
        { //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
        else
        { //更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser,example);
        }
    }

    public List<User> selectUser() {
        List<User> users = userExtMapper.selectUser();
        return users;
    }
}
