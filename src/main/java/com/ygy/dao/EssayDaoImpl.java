package com.ygy.dao;

import com.github.pagehelper.PageHelper;
import com.ygy.mapper.EssayMapper;
import com.ygy.model.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "essay")
public class EssayDaoImpl implements EssayDao {
    @Autowired
    private EssayMapper mapper;

    @Override
    @Transactional
    // @Cacheable(key = "#p0")
    public Essay SelectTitle(String title) {
        return this.mapper.selectTitle(title);
    }

    @Cacheable
    @Override
    public int addText(Essay essay) {
        return this.mapper.insert(essay);
    }

    @CachePut
    @Override
    public int updateText(Essay essay) {
        return this.mapper.updateByPrimaryKeySelective(essay);
    }

    @CacheEvict(beforeInvocation = true)
    @Override
    public int delete(int eid) {
        return this.mapper.deleteByPrimaryKey(eid);
    }

    @Override
    public List<Essay> SelectAllEssay() {
        return this.mapper.selectAllEssay();
    }

    @Override
    public List<Essay> findByPage() {
        return this.mapper.findByPage();
    }

    @Override
    public Essay findById(int eid) {
        return this.mapper.findById(eid);
    }

    @Override
    public List<Essay> findByCateName(String  cateName) {
        return this.mapper.findByCateName(cateName);
    }
}
