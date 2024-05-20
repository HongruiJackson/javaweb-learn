package com.jackson.mapper;

import com.jackson.pojo.Student;
import com.jackson.util.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class StudentMapperTest {


    @Test
    public void testSelectAll() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectAll();
            System.out.println(students);
        }
    }

    @Test
    public void testSelectById() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectById(1);
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByCondition() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            String name= "%j%";
            int age = 21;

            System.out.println(studentMapper.selectByConditionUseParam(name, age));

            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            System.out.println(studentMapper.selectByConditionUseClass(student));


            HashMap hashMap = new HashMap();
            hashMap.put("name",name);
            hashMap.put("age",age);
            System.out.println(studentMapper.selectByConditionUseMap(hashMap));


        }
    }

    @Test
    public void testAdd() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setName("zero");
            student.setAge(17);
            student.setSchool("lanxiang");
            studentMapper.add(student);
            System.out.println(student.getId());
            sqlSession.commit();
        }
    }

    @Test
    public void testUpdate() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setName("jackson");
            student.setAge(22);
            student.setId(2);
            studentMapper.update(student);
        }
    }

}
