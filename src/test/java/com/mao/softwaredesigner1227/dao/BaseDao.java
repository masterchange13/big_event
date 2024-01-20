package com.mao.softwaredesigner1227.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

public class BaseDao {
    private static QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public static int update(String sql, Object... params) {
        try {
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static <T> T get(Class<T> type, String sql, Object... params) {
        try {
            return queryRunner.query(sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public int selectCount(String sql, Object... params){
        try {
            return queryRunner.query(sql, new ScalarHandler<>(), params);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
