package com.lipin.service.impl;

import com.lipin.dao.UserDao;
import com.lipin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    //建構方法注入
    //有參構造
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    //無參構造
    public UserServiceImpl() {
    }

//set方法注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        userDao.save();
    }
}
