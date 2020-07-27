package com.lipin.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    //測試手動創建c3p0數據庫
    public void test01() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:8889/iii");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();

        String sql = "SELECT * FROM just";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
           System.out.println(rs.getString("account"));
        }

        System.out.println(connection);
        connection.close();

    }
    @Test
    //測試手動創建druid
    public void test02() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8889/iii");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        DruidPooledConnection connection = dataSource.getConnection();
        String sql = "SELECT * FROM just";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("account"));
        }
        System.out.println(connection);
        connection.close();
    }
    @Test
    //測試手動創建c3p0(使用加載properties配置文件)
    public void test03() throws Exception{
        //讀取配置文件
        //getBundle("")內的name是在Resource文件夾內的配置文件名稱
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        //連接數據庫
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM just";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString("account"));
        }
        System.out.println(connection);

        connection.close();

    }
    @Test
    //使用Spring配置文件產生數據連接
    public void test04()throws Exception{
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();

        System.out.println(connection);//測試是否有連上

        String sql = "SELECT * FROM just";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString("account"));
        }
        connection.close();
    }
}
