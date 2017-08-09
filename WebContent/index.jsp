<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.techstar.isay.Isay"%>
<%@page import="com.caucho.hessian.client.HessianProxyFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp页面测试 Hessian</h1>

<%
	//Hessian代理工厂
	HessianProxyFactory factory = new HessianProxyFactory();
	//获得访问配置的servlet路径 调用接口为：
	String url = ("http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/hello");
	//使用Hessian工厂获得接口的具体实现类
	Isay isay = (Isay)factory.create(Isay.class, url);
	out.println("<h2> "+"url为："+url+" 输出为： "+isay.sayHello("ni ", " hao")+"<h2>");
%>

</body>
</html>