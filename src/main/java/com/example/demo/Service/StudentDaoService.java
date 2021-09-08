package com.example.demo.Service;

import com.example.demo.Model.Activity;
import com.example.demo.Model.Student;
import com.example.demo.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentDaoService {

    @Autowired
    private StudentDao std;

    //新增
    public int insertActivity(Activity activity) {
        return std.insertActivity(activity);
    }

    //删除
    public int delete(int num) {
        return std.delete(num);
    }

    //修改
    public int update(Student student) {
        return std.update(student);
    }

    //查询所有学生信息
    public List<Map<String, Object>> query(String TableName) {
        return std.query(TableName);
    }


    //单个查询
    public List<Student> Stuquery(int Ssno) {
        return std.Stuquery(Ssno);
    }

}
