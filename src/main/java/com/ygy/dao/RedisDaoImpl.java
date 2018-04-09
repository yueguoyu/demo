package com.ygy.dao;

import com.ygy.mapper.EssayMapper;
import com.ygy.model.Essay;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.ELState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Override
    public void addhit(int eid) {
        HashOperations<String, Integer, Integer> operations = redisTemplate.opsForHash();
        int hit;
        try {
             hit= operations.get("hitHash", eid);
        } catch (Exception e) {
            hit=0;
        }

        hit++;
        operations.put("hitHash", eid, hit);
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
