package com.allst.java.hive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Java操作HiveApi
 *
 * @author YiYa
 * @since 2020/7/2-11:19
 */
public class OperHive {
    private static final Logger logger = LoggerFactory.getLogger(OperHive.class);

    public static void main(String[] args) {
        String driverName = "org.apache.hive.jdbc.HiveDriver"; // org.apache.hadoop.hive.jdbc.HiveDriver 会报错
        try {
            Class.forName(driverName);
            String url = "jdbc:hive2://192.168.2.22:10000/myhive";
            String username = "anonymous";
            String password = "anonymous";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // 创建的表名
            String tableName = "dept";

            /* 第一步:存在就先删除 **/
            String sql = "drop table " + tableName;
            stmt.execute(sql);

            /* 第二步:不存在就创建 **/
            sql = "create table " + tableName + " (id int, deptName string, deptNo string) row format delimited fields terminated by '\t'";
            stmt.execute(sql);

            // 执行“show tables”操作
            sql = "show tables '" + tableName + "'";
            System.out.println("Running:" + sql);
            ResultSet res = stmt.executeQuery(sql);
            System.out.println("执行“show tables”运行结果:");
            if (res.next()) {
                System.out.println(res.getString(1));
            }

            // 执行“describe table”操作
            sql = "describe " + tableName;
            System.out.println("Running:" + sql);
            res = stmt.executeQuery(sql);
            System.out.println("执行“describe table”运行结果:");
            while (res.next()) {
                System.out.println(res.getString(1) + "\t" + res.getString(2));
            }

            // 执行“load data into table”操作
            String filepath = "/root/data/dept.txt";
            sql = "load data local inpath '" + filepath + "' into table " + tableName;
            System.out.println("Running:" + sql);
            stmt.execute(sql);

            // 执行“select * query”操作
            sql = "select * from " + tableName;
            System.out.println("Running:" + sql);
            res = stmt.executeQuery(sql);
            System.out.println("执行“select * query”运行结果:");
            while (res.next()) {
                System.out.println(res.getInt(1) + "\t" + res.getString(2));
            }

            // 执行“regular hive query”操作
            sql = "select count(1) from " + tableName;
            System.out.println("Running:" + sql);
            res = stmt.executeQuery(sql);
            System.out.println("执行“regular hive query”运行结果:");
            while (res.next()) {
                System.out.println(res.getString(1));

            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(driverName + " not found!", e);
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Connection error!", e);
            System.exit(1);
        }
    }
}
