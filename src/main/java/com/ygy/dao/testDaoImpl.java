package com.ygy.dao;

import com.ygy.mapper.T1Mapper;
import com.ygy.model.T1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class testDaoImpl implements testDao {
    @Autowired
    T1Mapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T1 select(int id) {
        return mapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(T1 t1) {
        this.mapper.insert(t1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(int id) {
        this.mapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(T1 t1) {
        this.mapper.update(t1);
    }
}
