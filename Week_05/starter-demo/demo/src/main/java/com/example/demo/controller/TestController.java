package com.example.demo.controller;

import com.example.demo.jdbc.OriginalJdbc;
import com.example.job.handler.Klass;
import com.example.job.handler.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author
 * @date 2020/11/18 0:33
 */
@RestController
public class TestController {

    @Resource
    Klass klass;

    @Resource
    School school;

    @Autowired
    OriginalJdbc originalJdbc;

    @RequestMapping("/getData")
    public void dong(){
        klass.dong();
        school.ding();
    }

    @RequestMapping("/jdbcTest")
    public void jdbcTest(){
        try {
            originalJdbc.jdbcTask();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
