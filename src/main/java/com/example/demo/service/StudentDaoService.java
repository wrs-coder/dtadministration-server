package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.dao.StudentDao;
import com.example.demo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Peter
 */
@Service
public class StudentDaoService {

    @Autowired
    private StudentDao std;

    /**
     * 查询
     */
    public List<Map<String, Object>> search(String tableName, String type, String content) {
        return std.search(tableName, type, content);
    }


    /**
     * 新增活动
     */
    public int insertActivity(Activity activity) {
        return std.insertActivity(activity);
    }

    /**
     * 新增人员
     */
    public int insertPeople(People people) {
        return std.insertPeople(people);
    }

    /**
     * 删除
     */
    public int delete(String uuid, String tableName) {
        return std.delete(uuid, tableName);
    }

    /**
     * 修改人员
     */
    public int update(People people) {
        return std.updatePeople(people);
    }

    /**
     * 修改活动
     */
    public int update(Activity activity) {
        return std.updateActivity(activity);
    }

    /**
     * 查询
     */
    public List<Map<String, Object>> query(String tablesName) {
        return std.query(tablesName);
    }

    /**
     * 单个查询
     */
    public List<Map<String, Object>> stuQuery(String tableName, String name) {
        return std.stuQuery(tableName, name);
    }
}
