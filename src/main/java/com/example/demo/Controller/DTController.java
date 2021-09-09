package com.example.demo.Controller;

import com.example.demo.Dao.StudentDao;
import com.example.demo.Model.Activity;
import com.example.demo.Model.People;
import com.example.demo.Model.Users;
import com.example.demo.Response.Result;
import com.example.demo.Response.ResultFactory;
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

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DTController {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //登录
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
        } else
            System.out.println("登录验证失败");
        return ResultFactory.buildSuccessResult(list);
    }

    //新增活动
    @CrossOrigin
    @RequestMapping("/insertActivity")
    public Result addStudent(@RequestBody Activity activity) {
        activity.setUuid(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        studentDao.insertActivity(activity);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    //新增人员
    @CrossOrigin
    @RequestMapping("/insertPeople")
    public Result addPeople(@RequestBody People people) {
        studentDao.insertPeople(people);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    //删除
    @CrossOrigin
    @RequestMapping("/delete")
    public void deleteStudent(@RequestBody String deleteList) throws JSONException {
        JSONObject json = new JSONObject(deleteList);
        String uuid = (String) json.getJSONObject("deleteList").get("uuid");
        String TableName = (String) json.getJSONObject("deleteList").get("tableName");
        studentDao.delete(uuid, TableName);
    }

    //修改人员信息
    @CrossOrigin
    @RequestMapping("/updatePeople")
    public Result updateStudent(@RequestBody People people) {
        studentDao.updatePeople(people);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    //修改活动信息
    @CrossOrigin
    @RequestMapping("/updateActivity")
    public Result updateStudent(@RequestBody Activity activity) {
        studentDao.updateActivity(activity);
        return ResultFactory.buildSuccessResult(studentDao);
    }

    //查询
    @CrossOrigin
    @RequestMapping("/query")
    public Result queryAll(@RequestBody String tableName) throws JSONException {
        JSONObject json = new JSONObject(tableName);
        String TableName = (String) json.get("tableName");
        List<Map<String, Object>> list = studentDao.query(TableName);
        return ResultFactory.buildSuccessResult(list);
    }

    //单个查询
    @CrossOrigin
    @RequestMapping("/Studentquery")
    public Result queryStd(@RequestBody String queryList) throws JSONException {
        JSONObject json = new JSONObject(queryList);
        String TableName = (String) json.getJSONObject("queryList").get("tableName");
        String name = (String) json.getJSONObject("queryList").get("name");
        List<Map<String, Object>> StuList = studentDao.Stuquery(TableName, name);
        return ResultFactory.buildSuccessResult(StuList);
    }

}
