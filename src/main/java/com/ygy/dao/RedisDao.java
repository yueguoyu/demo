package com.ygy.dao;

public interface RedisDao {
     void addhit(int eid,String username);
     int selecthit(int eid);
}
