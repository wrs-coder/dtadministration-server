package com.example.demo.Dao;

import com.example.demo.Model.Activity;
import com.example.demo.Model.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentDao {
    //新增活动
    int insertActivity(Activity activity);

    //新增人员
    int insertPeople(People people);

    //删除
    int delete(String uuid, String TableName);

    //修改人员
    int updatePeople(People people);

    //修改活动
    int updateActivity(Activity activity);

    //查询所有学生信息
    List<Map<String, Object>> query(@Param(value = "TableName") String TableName);

    //单个查询
    List<Map<String, Object>> Stuquery(String TableName, String name);
}
