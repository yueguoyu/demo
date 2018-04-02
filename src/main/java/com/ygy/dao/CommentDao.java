package com.ygy.dao;

import com.ygy.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    void addComment(Comment comment);
    List<Map<String, String>> selectByeid(int eid);
}
