package com.jackson.mapper;

import com.jackson.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> selectAll();

    Student selectById(int id);

    List<Student> selectByConditionUseParam(@Param("name") String name,
                                            @Param("age") int age);

    List<Student> selectByConditionUseClass(Student student);

    List<Student> selectByConditionUseMap(Map map);

    void add(Student student);

    void update(Student student);

    void deleteById(int id);

}
