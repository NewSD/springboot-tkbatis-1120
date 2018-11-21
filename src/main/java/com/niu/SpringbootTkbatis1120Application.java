package com.niu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.niu.dao")//mapper接口的路径
public class SpringbootTkbatis1120Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTkbatis1120Application.class, args);
	}



}
