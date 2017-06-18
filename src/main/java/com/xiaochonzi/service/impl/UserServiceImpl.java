package com.xiaochonzi.service.impl;

import com.xiaochonzi.dao.UserDAO;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by stone on 17/6/11.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;


    public User selectUserByUser(User user) {
        return userDAO.selectByUser(user);
    }

    public int register(User user) {
        return userDAO.insertUser(user);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
