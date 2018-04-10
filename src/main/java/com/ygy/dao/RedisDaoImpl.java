package com.ygy.dao;

import com.ygy.mapper.EssayMapper;
import com.ygy.model.Essay;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.ELState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RedisDaoImpl implements RedisDao {

    @Autowired
    EssayMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    static SetOperations<Integer,String> operations1;
    static HashOperations<String, Integer, Integer> operations;

    @Override
    public void addhit(int eid,String username) {
         operations1=redisTemplate.opsForSet();
       operations = redisTemplate.opsForHash();

        int hit;
        try {
             hit= operations.get("hitHash", eid);
        } catch (Exception e) {
            hit=0;
        }
//加一个判断
        if (!operations1.isMember(eid,username)){
            hit++;
            operations1.add(eid,username);
            operations.put("hitHash", eid, hit);
        }else {
            System.out.println("hahhahahah");
//            return;
        }

    }

    @Override
    public int selecthit(int eid) {
        boolean re = redisTemplate.hasKey("hitHash");
        int hit = 0;
        HashOperations<String, Integer, Integer> operations = redisTemplate.opsForHash();
        if (!re) {
            Essay essay = mapper.findById(eid);
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(eid, essay.getHit());
            operations.putAll("hitHash", map);
        } else {
            try {
                hit = operations.get("hitHash", eid);
            } catch (Exception e) {
                hit = 0;
            }

        }
        return hit;
    }
}
