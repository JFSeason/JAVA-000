package com.example.job.handler;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @date 2020/11/18 16:40
 */
@Data
@Component
public class Klass {
    List<Student> students;
    public void dong(){
        System.out.println(this.getStudents());
    }
}
