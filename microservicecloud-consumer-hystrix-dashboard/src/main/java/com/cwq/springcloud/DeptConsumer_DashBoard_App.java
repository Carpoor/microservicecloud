package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/** 
 * 被监视的hystrix模块，需要加入actuator
 * http://localhost:9001/hystrix  web平台配置需要监控的模块
 * 				^^
 * 				配置
 * 				||
 * http://localhost:8001/hystrix.stream 一直刷新服务的调用信息，不过都是json串，监控平台将这些json数据进行图形化展示 
 * @author Carpoor  
 * @date 2019年1月2日 
 */
@SpringBootApplication
@EnableHystrixDashboard//开启监视器
public class DeptConsumer_DashBoard_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}

}
