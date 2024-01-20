package com.mao.softwaredesigner1227.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DruidUtils {

    private static DataSource dataSource;

    // 获取配置文件流信息
    // 创建对象加载配置文件
    public void test() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            try {
                properties.load(inputStream);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            // 获取连接对象
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            try {
                Class.forName(driver);
                DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //1.初始化Druid连接池
    static {
        //第二种方式:使用软编码通过配置文件初始化DBCP
        try {
            Properties properties = new Properties();
            //通过类加载器加载配置文件
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream(
                    "druid.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDataSource(){
        return  dataSource;
    }

    // 获取连接对象
//    public static Connection getConnection() {
//        try {
//            DatabaseMetaData datasource;
//            datasource = null;
//            return datasource.getConnection();
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static DataSource getDataSource()  {
//            return dataSource;
//    }


}
