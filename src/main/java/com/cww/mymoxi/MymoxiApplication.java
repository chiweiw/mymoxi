package com.cww.mymoxi;

import com.cww.mymoxi.configurer.swagger.EnableMySwagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.cww.mymoxi.dao")
@EnableMySwagger
public class MymoxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymoxiApplication.class, args);
	}
}
