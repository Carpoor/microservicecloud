package com.cwq.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

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
	/*
IRule(接口) 根据特定算法中从服务列表中选取一个要访问的服务
AbstractLoadBalancerRule，该抽象类实现了IRule接口，其子类（负载均衡规则）如下
实现类及相关规则如下：
RoundRobinRule 轮询（默认）
修改负载均衡规则，只需要将下面算法放入IOC容器中
RandomRule 随机
AvailabilityFilteringRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务， 
	还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
WeightedResponseTimeRule 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
 	刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够， 会切换到WeightedResponseTimeRule
RetryRule 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
BestAvailableRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
ZoneAvoidanceRule 默认规则,复合判断server所在区域的性能和server的可用性选择服务器 
	 */
//	@Bean
//	public IRule rule() {
//		return new RandomRule();
//	}
	
}
