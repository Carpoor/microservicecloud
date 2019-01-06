package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/** 
 * @author Carpoor  
 * @date 2019年1月5日 
 */
@SpringBootApplication
@EnableZuulProxy //开启zuul网关
public class Zuul_9527_StartSpringCloudApp {

	public static void main(String[] args) {
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}

}
