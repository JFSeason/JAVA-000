package com.example.job.handler;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date 2020/11/18 16:39
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "student")
public class Student {
    private int id;
    private String name;
}
