package com.ygy.dao;

import com.ygy.model.User;

public interface UserDao {
    public boolean login(User user);
    public boolean UpdateUser(User user);
}
