package com.example.firstappdemo;

import com.example.firstappdemo.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {

    @Bean
    public Student stu(){
        return new Student("jack", 18);
    }
}
