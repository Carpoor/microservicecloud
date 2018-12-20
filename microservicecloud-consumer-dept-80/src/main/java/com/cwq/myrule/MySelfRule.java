package com.cwq.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/** 
 * @author Carpoor  
 * @date 2018年12月20日 
 */
@Configuration
public class MySelfRule {

	/**
	 * 将默认的轮询算法改为随机算法
	 * @return
	 */
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
	
}
