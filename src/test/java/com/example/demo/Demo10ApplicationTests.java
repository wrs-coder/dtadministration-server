package com.example.demo;

import com.example.demo.dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class Demo10ApplicationTests {

    @Resource
    StudentDao studentDao;

    @Test
    void contextLoads() throws SQLException {

    }
}


