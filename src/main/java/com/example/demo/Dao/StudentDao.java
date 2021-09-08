package com.example.demo.Dao;

import com.example.demo.Model.Activity;
import com.example.demo.Model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentDao {
    //新增
    int insertActivity(Activity activity);

    //删除
    int delete(int num);

    //修改
    int update(Student student);

    //查询所有学生信息
    List<Map<String, Object>> query(@Param(value = "TableName") String TableName);

    //单个查询
    List<Student> Stuquery(int Ssno);
}
