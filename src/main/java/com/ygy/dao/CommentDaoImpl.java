package com.ygy.dao;

import com.ygy.mapper.CommentMapper;
import com.ygy.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CommentMapper mapper;
    @Override
    public void  addComment(Comment comment) {
        String key="Essay"+comment.getEid();
       HashOperations<String,String,String> operations=redisTemplate.opsForHash();
        Map<String,String> map=new HashMap<String, String>();
        map.put(comment.getCommname(),comment.getCommtext());
       operations.putAll(key,map);
        System.out.println("name:"+comment.getCommname());
    }

    @Override
    public List<Map<String, String>> selectByeid(int eid) {
        String key="Essay"+eid;
        HashOperations<String,String,String> operations=redisTemplate.opsForHash();
        Map map=operations.entries(key);

        List<Map<String,String>> maps=new LinkedList<Map<String, String>>();
           maps.add(operations.entries(key));
        return maps;
    }
}
