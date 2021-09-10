package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Activity;
import com.example.demo.model.People;
import com.example.demo.model.Users;
import com.example.demo.response.Result;
import com.example.demo.response.ResultFactory;
import com.example.demo.utils.TokenUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Peter
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 登录
     */
    @CrossOrigin
    @RequestMapping(value = "/login")
    public Result login(@RequestBody String form) throws JSONException {
        Map<String, Object> map = new HashMap<>();
        JSONObject object = new JSONObject(form);
        map.put("username", object.getJSONObject("form").get("username").toString());
        map.put("password", object.getJSONObject("form").get("password").toString());
        String sql = "select username,password from DT_users where username = ? and password = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, map.get("username"), map.get("password"));
        if (!list.isEmpty()) {
            String username = (String) map.get("username");
            String password = (String) map.get("password");
            String token = TokenUtil.sign(new Users(username, password));
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("token", token);
            System.out.println("登录验证成功，返回token");
            return ResultFactory.buildSuccessResult(hs);
        } else {
            System.out.println("登录验证失败");
        }
        return ResultFactory.buildSuccessResult(list);
    }

    /**
     * 新增活动
     */
    @CrossOrigin
    @RequestMapping("/insertActivity")
    public Result addStudent(@RequestBody Activity activity) {
        activity.setUuid(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        studentDao.insertActivity(activity);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    /**
     * 新增人员
     */
    @CrossOrigin
    @RequestMapping("/insertPeople")
    public Result addPeople(@RequestBody People people) {
        studentDao.insertPeople(people);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    /**
     * 删除
     */
    @CrossOrigin
    @RequestMapping("/delete")
    public void deleteStudent(@RequestBody String deleteList) throws JSONException {
        JSONObject json = new JSONObject(deleteList);
        String uuid = (String) json.getJSONObject("deleteList").get("uuid");
        String tableName = (String) json.getJSONObject("deleteList").get("tableName");
        studentDao.delete(uuid, tableName);
    }

    /**
     * 修改人员信息
     */
    @CrossOrigin
    @RequestMapping("/updatePeople")
    public Result updateStudent(@RequestBody People people) {
        studentDao.updatePeople(people);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    /**
     * 修改活动信息
     */
    @CrossOrigin
    @RequestMapping("/updateActivity")
    public Result updateStudent(@RequestBody Activity activity) {
        studentDao.updateActivity(activity);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    /**
     * 查询
     */
    @CrossOrigin
    @RequestMapping("/query")
    public Result queryAll(@RequestBody String tableName) throws JSONException {
        JSONObject json = new JSONObject(tableName);
        String tablesName = (String) json.get("tableName");
        List<Map<String, Object>> list = studentDao.query(tablesName);
        return ResultFactory.buildSuccessResult(list);
    }

    /**
     * 单个查询
     */
    @CrossOrigin
    @RequestMapping("/StudentQuery")
    public Result queryStd(@RequestBody String queryList) throws JSONException {
        JSONObject json = new JSONObject(queryList);
        String tableName = (String) json.getJSONObject("queryList").get("tableName");
        String name = (String) json.getJSONObject("queryList").get("name");
        List<Map<String, Object>> stuList = studentDao.stuQuery(tableName, name);
        return ResultFactory.buildSuccessResult(stuList);
    }

}
