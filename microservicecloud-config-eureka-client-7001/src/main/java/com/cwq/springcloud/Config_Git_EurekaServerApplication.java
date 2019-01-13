package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/** 
 * @author Carpoor  
 * @date 2019年1月13日 
 */
@SpringBootApplication 
@EnableEurekaServer 
public class Config_Git_EurekaServerApplication 
{
  public static void main(String[] args) 
  {
   SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
  }
}
 
 