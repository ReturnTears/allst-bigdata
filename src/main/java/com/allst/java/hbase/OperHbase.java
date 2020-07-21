package com.allst.java.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author YiYa
 * @since 2020/7/21-22:06
 */
public class OperHbase {
    public static void main(String[] args) throws URISyntaxException {
        Configuration config = HBaseConfiguration.create();
        // 获取配置文件
        config.addResource(new Path(ClassLoader.getSystemResource("hbase-site.xml").toURI()));
        config.addResource(new Path(ClassLoader.getSystemResource("core-site.xml").toURI()));
        // 创建链接
        try {
            Connection connection = ConnectionFactory.createConnection(config);
            Admin admin = connection.getAdmin();
            TableName tableName = TableName.valueOf("mytable");
            // 定义表
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            // 定义列族
            HColumnDescriptor mycf = new HColumnDescriptor("mycf");
            tableDescriptor.addFamily(mycf);
            admin.createTable(tableDescriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
