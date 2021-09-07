package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDaoService {

    @Autowired
    private StudentDao std;

    //新增
    public int insert(Student student) {
        return std.insert(student);
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
    public List<Student> query() {
        return std.query();
    }


    //单个查询
    public List<Student> Stuquery(int Ssno) {
        return std.Stuquery(Ssno);
    }

}
