package com.allst.java;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * 使用JDBC进行Hive操作, 如果执行以下测试方法报错：connect time out， 估计需要关闭防火墙
 *
 * @author YiYa
 * @since 2020/7/2-11:27
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HiveTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Connection connection = null;

    @BeforeAll
    void init() throws Exception {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            connection = DriverManager.getConnection("jdbc:hive2://192.168.2.22:10000/myhive", "anonymous", "anonymous");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("创建Hive连接失败", e);
            throw e;
        }
    }

    @AfterAll
    void destory() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
    /**
     * 创建数据库
     */
    @Order(1)
    @Test
    void createDatabase() {
        String sql = "create database test_db";
        logger.info("创建数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            logger.info("创建数据库成功");
        } catch (SQLException e) {
            logger.error("创建数据库出错", e);
        }
    }

    /**
     * 查询数据库
     */
    @Order(2)
    @Test
    void showDatabases() {
        String sql = "show databases";
        logger.info("查询数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("查询到数据库 : " + rs.getString(1));
                logger.info("查询到数据库：{}", rs.getString(1));
            }
        } catch (SQLException e) {
            logger.error("创建数据库出错", e);
        }
    }

    /**
     * 创建表
     */
    @Order(3)
    @Test
    void createTable() {
        String sql = "create table user_tb(id int, name string) row format delimited fields terminated by ','";
        logger.info("创建表，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            logger.info("创建表成功");
        } catch (SQLException e) {
            logger.error("创建表出错", e);
        }
    }

    /**
     * 查询所有表
     */
    @Order(3)
    @Test
    void showTables() {
        String sql = "show tables";
        logger.info("查询所有表，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("查询到表 : " + rs.getString(1));
                logger.info("查询到表：{}", rs.getString(1));
            }
        } catch (SQLException e) {
            logger.error("查询所有表出错", e);
        }
    }

    /**
     * 查看表结构
     */
    @Order(4)
    @Test
    void descTable() {
        String sql = "desc user_tb";
        logger.info("查看表结构，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                logger.info("字段名：{}，类型：{}", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            logger.error("查看表结构出错", e);
        }
    }

    /**
     * 导入数据，data.txt中的数据为格式为：<br>
     * 1,张三<br>
     * 2,李四
     */
    @Order(5)
    @Test
    void loadData() {
        String sql = "load data local inpath '/home/data.txt' overwrite into table user_tb";
        logger.info("导入数据，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            logger.info("导入数据成功");
        } catch (SQLException e) {
            logger.error("导入数据出错", e);
        }
    }

    /**
     * 查询数据
     */
    @Order(6)
    @Test
    void selectData() {
        String sql = "select * from user_tb";
        logger.info("查询数据，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                logger.info("id={},name={}", rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            logger.error("查询数据出错", e);
        }
    }

    /**
     * 查数量
     */
    @Order(7)
    @Test
    void count() {
        String sql = "select count(1) from user_tb";
        logger.info("查数量，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                logger.info("数量={}", rs.getInt(1));
            }
        } catch (SQLException e) {
            logger.error("查数量出错", e);
        }
    }

    /**
     * 删除表
     */
    @Order(8)
    @Test
    void deopTable() {
        String sql = "drop table if exists user_tb";
        logger.info("删除表，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            logger.info("删除表成功");
        } catch (SQLException e) {
            logger.error("删除表出错", e);
        }
    }

    /**
     * 删除数据库
     */
    @Order(9)
    @Test
    void dropDatabase() {
        String sql = "drop database if exists test_db";
        logger.info("删除数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            logger.info("删除数据库成功");
        } catch (SQLException e) {
            logger.error("删除数据库出错", e);
        }
    }
}
