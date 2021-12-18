package com.example.mybatisgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 1. 表明当前项目为SpringBoot工程，这是一个启动类，也是应用程序入口类
 * 2. 启动类需要放在跟包路径之下(com.imooc)
 * 		因为它会默认扫描controller和service以及mapper等一些相关的组件
 * 		扫描完了之后，会放入到spring/springboot的容器中
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
public class MybatisGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisGeneratorApplication.class, args);
	}

}
