package com.cwq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cwq.springcloud.entities.Dept;
import com.cwq.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {

	@Autowired
	private DeptClientService service;
	
	/**
	 * 形参前面没有加@requestBody，因为消费者供前端使用，前端是传着过来，不是传json串，无需解析
	 * 生产者对应的方法中，形参前面加了@requestBody，是因为经过restTemplate传送对象，会封装为json串，所以需要解析为Dept类
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return service.list();
	}

}
