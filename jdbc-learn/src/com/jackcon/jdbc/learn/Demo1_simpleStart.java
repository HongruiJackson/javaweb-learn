package com.jackcon.jdbc.learn;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;

public class Demo1_simpleStart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://120.26.93.84:3306/javaWebLearn";
        String username = "root";
        String password = "e53jxbg6%2";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "insert into student(name,age) values('ian',21)";



        // 4. 获取sql的对象
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 受影响的行数

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        stmt.close();
        conn.close();


    }


}
