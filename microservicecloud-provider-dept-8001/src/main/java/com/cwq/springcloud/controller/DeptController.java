package com.cwq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cwq.springcloud.entities.Dept;
import com.cwq.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}
	/**
	 * 注：一般该服务发现方式很少用到，基本上不用，这儿只是为了了解做了记录
	eureka提供用于做服务发现的类
	（
	生效还需要在主程序类上标注@EnableDiscoveryClient//发现eureka中的服务
	参照DeptProvider8001_APP类
	）
	import org.springframework.cloud.client.discovery.DiscoveryClient;
	@Autowired
	private DiscoveryClient client;
	该类可以获取到eureka管理页面中所有注册了的服务信息，如下面方法所示
	 * @return
	 */
	@RequestMapping(value="/dept/discovery", method= RequestMethod.GET)
	public Object  discovery() {
		//获取所有的服务名称
		List<String> services = client.getServices();
		System.out.println("eureka上的所有服务为 ： "+services);
		//获取每个服务的所有信息
		List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance instance : instances) {
			System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" +
					instance.getPort() + "\t" + instance.getUri());
		}
		return client;
	}

}
