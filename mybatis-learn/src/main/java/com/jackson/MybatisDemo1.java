package com.jackson;

import com.jackson.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo1 {

    public static void main(String[] args) throws IOException {
        //1. 加载核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //2. 获取sqlSession对话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try (sqlSession) {
            List<Student> students = sqlSession.selectList("test.selectAll");
            System.out.println(students);

        }


    }

}
