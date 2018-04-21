package com.ygy.dao;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.ygy.mapper.EssayMapper;
import com.ygy.model.Essay;
import groovy.transform.ASTTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author ygy
 * @date
 */
@Service
public class EssayDaoImpl implements EssayDao {
    @Autowired
    private EssayMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private BloomFilter<String> bloomfil;
    /**
     * 在spring容器初始化的时候执行该方法
     */
    @PostConstruct
    private void init(){
        List<String> list=mapper.findAllTitle();
        //布隆过滤器的容量
        int bloomfilLen=(int)(list.size()*1.2);
        bloomfil= com.google.common.hash.BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),bloomfilLen,0.001);
        for (String str:list){
            //因为我的题目有null
            if (str!=null){
                bloomfil.put(str);
            }

        }
    }

    @Override
    @Transactional
//
    public Essay SelectTitle(String title) {
        ValueOperations<String,Essay> operations=redisTemplate.opsForValue();
        boolean haskey=redisTemplate.hasKey(title);
        if (!bloomfil.mightContain(title)){
            System.out.println("hahhahahhahhahaha");
            return null;
        }
        if (haskey){
            System.out.println("by========redis");
           Essay essay= operations.get(title);
           return essay;
        }
        Essay essay=this.mapper.selectTitle(title);
        operations.set(title,essay,60,TimeUnit.SECONDS);
        return essay;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addText(Essay essay) {
        return this.mapper.insert(essay);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateText(Essay essay) {
        return this.mapper.updateByPrimaryKeySelective(essay);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int eid) {
        return this.mapper.deleteByPrimaryKey(eid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> SelectAllEssay() {
        return this.mapper.selectAllEssay();
    }
    ZSetOperations<String,Essay> zSetOperations;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByPage() {
        List<Essay> essayList= this.mapper.findByPage();
        return  essayList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Essay findById(int eid) {
        String key = "ygy" + eid;
        ValueOperations<String, Essay> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if (haskey) {
            Essay essay = operations.get(key);
            return essay;
        }
        Essay essay = this.mapper.findById(eid);
        operations.set(key, essay, 60, TimeUnit.SECONDS);


        return essay;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByCateName(String cateName) {
        boolean haskey = redisTemplate.hasKey(cateName);
        ValueOperations<String, List<Essay>> operations = redisTemplate.opsForValue();
        if (haskey) {
            List<Essay> essayList = operations.get(cateName);
            return essayList;
        }
        List<Essay> essayList = this.mapper.findByCateName(cateName);
        operations.set(cateName, essayList, 20, TimeUnit.SECONDS);
        return essayList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByDim(String title) {
        String key="dim"+title;
        ValueOperations<String,List<Essay>> operations=redisTemplate.opsForValue();
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
           List<Essay> essays =operations.get(key);
           return essays;
        }
        List<Essay> essays=this.mapper.findByDim(title);
        operations.set(key,essays,60,TimeUnit.SECONDS);
        return essays;
    }

    @Override
    public List<Essay> sortByHit() {
        zSetOperations=redisTemplate.opsForZSet();
        HashOperations<String, Integer, Integer> operations=redisTemplate.opsForHash();
        List<Essay> essayList= this.mapper.findByPage();
        int hit=0;
        for (Essay essay:essayList){
            try{
                hit=operations.get("hitHash",essay.getEid());
            }catch (Exception e){

            }
            zSetOperations.add("hitZset",essay,hit);
        }

        Set<Essay> set=zSetOperations.reverseRange("hitZset",0,2);
        List<Essay> newEssayList1=new ArrayList<Essay>(set);
        return newEssayList1;
    }
}
