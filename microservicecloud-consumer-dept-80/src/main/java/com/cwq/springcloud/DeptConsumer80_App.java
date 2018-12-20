package com.cwq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.cwq.myrule.MySelfRule;
/**
@RibbonClient注解
官方文档明确给出了警告：
这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说
我们达不到特殊化定制的目的了。
 * @author Carpoor  
 * @date 2018年12月20日
 */
@SpringBootApplication
@EnableEurekaClient//开启eureka服务
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效===>特定服务配置特定算法
//注意点：指定的ribbon配置类，不能放在DeptConsumer80_App（因为含有@ComponentScan）这个类所在的包以及子包下
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration= {MySelfRule.class})
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
