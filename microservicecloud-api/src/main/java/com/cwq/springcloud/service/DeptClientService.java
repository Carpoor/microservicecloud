package com.cwq.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cwq.springcloud.entities.Dept;

/**
 * @author Carpoor
 * @date 2018年12月24日
 */
//指定对应的服务，即可面对接口编程
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
//指定对应的服务降级处理类
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory=DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

	//这儿的路径需要和provider的路径一样
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);

}
