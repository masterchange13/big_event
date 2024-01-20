package com.mao.softwaredesigner1227.dao;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Student {
    public static void main(String[] args) throws SQLException {
    }

    public void delete() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        Statement statement = conn.createStatement();
        String sql = "delete from scorereport where id = A10001";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public void insert() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        Statement statement = conn.createStatement();
        String sql = "insert into scorereport (id, name, mathScore, englishScore) values ('A10001', '张三', 90, 100)";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public void getData() throws SQLException {

    }

}
