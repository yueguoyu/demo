package com.ygy.mapper;

import com.ygy.model.T1;

public interface T1Mapper {
   public T1 selectById(int id);
   public void insert(T1 t1);
   public void update(T1 t1);
   public void delete(int id);
}