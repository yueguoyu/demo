package com.ygy.dao;

import com.ygy.model.Comment;

import java.util.List;

public interface CommentDao {
    int addComment(Comment comment);
    List<Comment> selectByeid(int eid);
}
