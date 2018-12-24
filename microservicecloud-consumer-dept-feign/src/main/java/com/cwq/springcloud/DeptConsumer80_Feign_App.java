package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Carpoor  
 * @date 2018年12月20日
 */
@SpringBootApplication
@EnableEurekaClient//开启eureka服务
//开启feign，指定包的时候，是指定整体的，单独指定service程序不能使用
@EnableFeignClients(value="com.cwq.springcloud")
@ComponentScan(value="com.cwq.springcloud")//扫描包
public class DeptConsumer80_Feign_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}

}
