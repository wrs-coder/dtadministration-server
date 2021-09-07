package com.example.demo;

import com.example.demo.Dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class Demo10ApplicationTests {

    @Resource
    StudentDao studentDao;

    @Test
    void contextLoads() throws SQLException {
//        List<Map<String, Object>> list = studentDao.getStudentList();
//        System.out.println(list);

    }
}


