package com.lipin.test;

import com.lipin.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringText {

    /**
     * 單元測試
     */
    @Test
    public void test01(){
        //拿取配置文件
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //介面實例化,拿取Bean標籤底下的id,從而獲取該class的value,實例化的java文件
        UserDao userDao01 = (UserDao) app.getBean("userDao");

        System.out.println(userDao01);

//        ((ClassPathXmlApplicationContext)app).close();

        app.close();
    }

}
