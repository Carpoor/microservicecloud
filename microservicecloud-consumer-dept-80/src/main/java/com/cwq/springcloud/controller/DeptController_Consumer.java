package com.cwq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cwq.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

	private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	/**
	 * spring提供用于rest风格的http请求操作类
	 * 不会自动配置，需要自己配置为spring的容器bean（参照com.cwq.springcloud.cfgbeans）
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 形参前面没有加@requestBody，因为消费者供前端使用，前端是传着过来，不是传json串，无需解析
	 * 生产者对应的方法中，形参前面加了@requestBody，是因为经过restTemplate传送对象，会封装为json串，所以需要解析为Dept类
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") String id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	/**
	 * 远程调用，暴露给前端服务列表，这样前端就可以知道有哪些服务在运行
	 * 因为eureka的网址一般只有内部才能访问
	 * @return
	 */
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}
