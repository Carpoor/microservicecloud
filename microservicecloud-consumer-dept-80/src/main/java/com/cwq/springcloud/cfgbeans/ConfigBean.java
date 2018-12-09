package com.cwq.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	/**
	 * ribbon提供客户端负载均衡算法，也就是在客户端方面使用的
	 *    客户端实际使用了RestTemplate类进行交互
	 * @LoadBalanced注解 使得RestTemplate可以进行负载均衡选择对应的服务
	 * @return
	 */
	@Bean
	@LoadBalanced 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
