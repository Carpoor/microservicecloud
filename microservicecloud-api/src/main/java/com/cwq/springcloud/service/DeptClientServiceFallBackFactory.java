package com.cwq.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cwq.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

/** 
 * 由该类处理服务降级的操作，这儿囊括了对应接口所有的方法
 * 需要和feign结合使用
 * provider没有启动，对应的方法没办法调通，则采用该类返回，不会造成服务超时和不可用，等到启动的时候自动可以调用
 * @author Carpoor  
 * @date 2018年12月28日 
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
		     public Dept get(long id)
		     {
		       return new Dept().setDeptno(id)
		               .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
		               .setDb_source("no this database in MySQL");
		     }
		 
		     @Override
		     public List<Dept> list()
		     {
		       return null;
		     }
		 
		     @Override
		     public boolean add(Dept dept)
		     {
		       return false;
		     }
		   };

	}

}
