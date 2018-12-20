package com.cwq.myrule;

import java.util.List;
import java.util.Random;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/** 
 * 自定义负载均衡算法
需求：
依旧轮询策略，但是加上新需求，每个服务器要求被调用5次。也即
以前是每台机器一次，现在是每台机器5次
 * 
 * @author Carpoor  
 * @date 2018年12月20日 
 */
public class MyRoundRobinRule  extends AbstractLoadBalancerRule {

	private int total = 0; //总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0;//当前提供服务的机器号
	
	public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            //===================================
            //复制了RandomRule()负载均衡随机算法的源码进行修改，主要变动的逻辑在此处
            //当调用在5次内，currentIndex不变，都返回相同的服务
            if (total < 5) {
				server = allList.get(currentIndex);
				total++;
			//达到五次调用，重定义参数
			} else {
				total = 0;
				currentIndex++;
				//控制索引的有效性，当索引等于服务总数时，重置为0，重新开始，达到轮询效果
				if (currentIndex >= serverCount) {
					currentIndex = 0;
				}
			}
            //====================================

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}

