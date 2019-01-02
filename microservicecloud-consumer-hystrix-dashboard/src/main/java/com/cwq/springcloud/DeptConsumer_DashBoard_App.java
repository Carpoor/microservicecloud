package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/** 
 * @author Carpoor  
 * @date 2019年1月2日 
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}

}
