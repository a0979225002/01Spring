package com.lipin.demo;

import com.lipin.service.UserService;
import com.lipin.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = app.getBean(UserService.class);

        userService.save();

        /**
         * 如果這樣寫會有啥效果
         * 報錯:NullPointerException
         * 原因,因為這不是從配置文件拿的,所以根本沒有實作出UserDao這個類
         */
//        UserService userService = new UserServiceImpl();
//        userService.save();

    }
}
