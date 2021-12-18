package com.example.firstappdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component      //把本配置放入到Spring容器中，使其被扫描到
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "MyConfig.properties", encoding = "utf-8")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyConfig {

    private String name;
    private int age;
    private String sex;
}
