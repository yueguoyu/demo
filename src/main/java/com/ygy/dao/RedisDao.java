package com.ygy.dao;

public interface RedisDao {
     void addhit(int eid);
     int selecthit(int eid);
}
