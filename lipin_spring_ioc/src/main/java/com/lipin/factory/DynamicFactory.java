package com.lipin.factory;

import com.lipin.dao.UserDao;
import com.lipin.dao.impl.UserDaoImpl;

public class DynamicFactory{
    public UserDao getUserDao(){

        return new UserDaoImpl();
    }
}
