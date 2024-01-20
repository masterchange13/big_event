package com.mao.softwaredesigner1227.dao2;

import com.mao.softwaredesigner1227.dao.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class BaseDao {
    private static QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    public int update(String sql,Object...args){
        try {
            return queryRunner.update(sql, args);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
