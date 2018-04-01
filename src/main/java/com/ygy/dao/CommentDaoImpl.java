package com.ygy.dao;

import com.ygy.mapper.CommentMapper;
import com.ygy.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private CommentMapper mapper;
    @Override
    public int addComment(Comment comment) {
       return  mapper.insert(comment);

    }

    @Override
    public List<Comment> selectByeid(int eid) {
        return mapper.selectByeid(eid);
    }
}
