package com.lipin.dao.impl;

import com.lipin.dao.UserDao;
import com.lipin.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    //集合注入
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    //普通注入
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //生命週期測試
    /*  public UserDaoImpl(){

        System.out.println("UserDaoImpl創建.....");
    }

    //生命週期測試
    public void init(){
      System.out.println("初始化執行方法...");
    }
    public void destory(){
        System.out.println("執行銷毀方法...");
    }*/

    public void save() {
//        System.out.println(username+"======"+age);

        System.out.println("strList:"+strList);
        System.out.println("userMap:"+userMap);
        System.out.println("properties:"+properties);

        System.out.println("save running....");
    }
}
