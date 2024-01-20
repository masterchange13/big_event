package com.mao.softwaredesigner1227.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public  static void main(String[] args) {
        findByLikeStudentTest();
    }

    public static void findByLikeStudentTest(){
        try {
            Connection conn = DruidUtils.getConnection();
            String sql = "select * from scorereport where name like concat('%',?,'%')";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "张");
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int mathscore = resultSet.getInt("mathscore");
                int englishscore = resultSet.getInt("englishscore");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
