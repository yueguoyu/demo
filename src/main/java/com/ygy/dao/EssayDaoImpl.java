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

/**
 * @author ygy
 * @date
 */
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

    //@Cacheable
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addText(Essay essay) {
        return this.mapper.insert(essay);
    }

   // @CachePut
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateText(Essay essay) {
        return this.mapper.updateByPrimaryKeySelective(essay);
    }

    @CacheEvict(beforeInvocation = true)
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByPage() {
        return this.mapper.findByPage();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Essay findById(int eid) {
        return this.mapper.findById(eid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByCateName(String  cateName) {
        return this.mapper.findByCateName(cateName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Essay> findByDim(String title) {
        return this.mapper.findByDim(title);
    }
}
