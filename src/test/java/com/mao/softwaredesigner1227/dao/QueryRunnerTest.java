package com.mao.softwaredesigner1227.dao;
import com.mao.softwaredesigner1227.entity.ScoreReport;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class QueryRunnerTest {

    @Test
    public void main(String[] args) {
        this.queryRunnerUpdate();
    }

    @Test
    public void getC(){
        try {
            Connection connection = DruidUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryRunnerCURD() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "delete from scorereport whereid = ?";
        Object[] object = {4};
        try {
            int result = queryRunner.update(sql, object);
            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryRunnerInsert() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insertinto scorereport(id,name,mathscore, englishscore) values(?,?,?, ?)";
        Object[] object = {5, "张三", 80, 85};
        try {
            int result = queryRunner.update(sql, object);
            result = queryRunner.update(sql, object);
            if (result > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryRunnerUpdate() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "update scorereport set mathscore = ?, englishscore = ? where id = ?";
        Object[] object = {85, 90, 5};
        try {
            int result = queryRunner.update(sql, object);
            if (result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryArraryListHandle() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from scorereport";

        try {
            List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
            for (Object object : list) {
                System.out.println(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryBeanListHandle() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from scorereport";

        try {
            List<ScoreReport> list = queryRunner.query(sql, new BeanListHandler<>(ScoreReport.class));
            for (ScoreReport scoreReport : list) {
                System.out.println(scoreReport.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public  void queryScalarHandle() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select count(*) from scorereport";
        try {
            long count = queryRunner.query(sql, new ScalarHandler<>());
            System.out.println("count = "+ count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
