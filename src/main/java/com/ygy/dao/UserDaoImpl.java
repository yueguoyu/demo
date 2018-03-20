package com.ygy.dao;

import com.ygy.mapper.UserMapper;
import com.ygy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper mapper;

    @Override
    public boolean login(User user) {
        int num = 0;
        num = this.mapper.selectByNamePass(user);
        if (num > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updateUser(User user) {
      int num=this.mapper.updatePass(user);
      if (num>0){
          return true;
      }else {
          return false;
      }
    }

    @Override
    public int addUser(User user) {
        return this.mapper.insert(user);
    }
    @Override
    public int updateStatus(User user) {
        return this.mapper.updateStatus(user);
    }
}
