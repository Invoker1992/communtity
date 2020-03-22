package com.mrh.community.mapper;

import com.mrh.community.dto.QuestionQueryDTO;
import com.mrh.community.model.Question;
import com.mrh.community.model.User;

import java.util.List;

public interface UserExtMapper {
    List<User> selectUser();

}