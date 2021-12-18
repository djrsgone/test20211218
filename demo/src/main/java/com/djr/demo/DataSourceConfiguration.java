package com.djr.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.h2.jdbcx.JdbcConnectionPool;

@Configuration
public class DataSourceConfiguration {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource h2DataSource(){
        return JdbcConnectionPool.create(url, user, password);
    }
}
