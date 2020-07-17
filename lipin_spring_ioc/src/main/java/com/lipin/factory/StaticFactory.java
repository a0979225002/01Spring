package com.lipin.factory;

import com.lipin.dao.UserDao;
import com.lipin.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao(){

        return new UserDaoImpl();
    }
}
