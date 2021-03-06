package com.cwq.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data//get set方法
@AllArgsConstructor//有参构造方法
@NoArgsConstructor//无参构造方法
@Accessors(chain=true)//用于开启级联set
public class Dept implements Serializable{

	private Long deptno; //主键
	private String dname; //部门名称
	private String db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public static void main(String[] args) {
		Dept dept = new Dept();
		System.out.println(dept.setDeptno(10L).setDname("dd"));
	}
	
}
