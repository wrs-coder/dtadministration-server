package com.example.demo.Service;

import com.example.demo.Model.Activity;
import com.example.demo.Dao.StudentDao;
import com.example.demo.Model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentDaoService {

    @Autowired
    private StudentDao std;

    //新增活动
    public int insertActivity(Activity activity) {
        return std.insertActivity(activity);
    }

    //新增人员
    public int insertPeople(People people) {
        return std.insertPeople(people);
    }

    //删除
    public int delete(String uuid, String TableName) {
        return std.delete(uuid, TableName);
    }

    //修改人员
    public int update(People people) {
        return std.updatePeople(people);
    }

    //修改活动
    public int update(Activity activity) {
        return std.updateActivity(activity);
    }

    //查询所有学生信息
    public List<Map<String, Object>> query(String TableName) {
        return std.query(TableName);
    }


    //单个查询
    public List<Map<String, Object>> Stuquery(String TableName, String name) {
        return std.Stuquery(TableName, name);
    }

}
