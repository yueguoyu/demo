package com.ygy.dao;

import com.ygy.model.T1;

public interface testDao {
    public void add(T1 t1);

    public T1 select(int id);

    public void update(T1 t1);

    public void delete(int id);
}
