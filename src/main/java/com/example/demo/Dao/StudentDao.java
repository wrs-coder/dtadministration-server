package com.example.demo.Dao;

import com.example.demo.Model.Student;
import com.example.demo.Model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentDao {
    //新增
    int insert(Student student);

    //删除
    int delete(int num);

    //修改
    int update(Student student);

    //查询所有学生信息
    List<Student> query();

    //单个查询
    List<Student> Stuquery(int Ssno);
}
