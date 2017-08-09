package com.techstar.test;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.techstar.isay.Isay;

public class Test {
	
	public static void main(String[] args) throws MalformedURLException{
		// Hessian 代理工厂
		HessianProxyFactory factory = new HessianProxyFactory();
		//设置访问的servlet路径 端口根据tomcat所定，本次是8082
		String url = "http://localhost:8082/tech09Hessian/hello";
		//获得Hessian工厂获取的几口具体实现类
		Isay isay = (Isay)factory.create(Isay.class,url);
		System.out.println(url+" 输出为： "+isay.sayHello("ni","hao"));
	}
}
