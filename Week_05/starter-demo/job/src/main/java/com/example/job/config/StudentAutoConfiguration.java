package com.example.job.config;

import com.example.job.handler.Klass;
import com.example.job.handler.School;
import com.example.job.handler.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2020/11/18 17:05
 */
@Configuration
@Import(Student.class)
@ConditionalOnProperty(prefix = "student", value = "enabled", havingValue = "true", matchIfMissing = true)
public class StudentAutoConfiguration {

    @Autowired
    Student student;


    @Bean
    public Klass klassService(){
        Klass k = new Klass();
        List<Student> list = new ArrayList<>();
        list.add(student);
        k.setStudents(list);
        return k;
    }

    @Bean
    public School schoolService(){
        Klass k = klassService();
        School school = new School();
        school.setClass1(k);
        school.setStudent100(student);
        return school;
    }
}
