package com.mrh.community.mapper;

import com.mrh.community.model.Comment;
import com.mrh.community.model.CommentExample;
import com.mrh.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}