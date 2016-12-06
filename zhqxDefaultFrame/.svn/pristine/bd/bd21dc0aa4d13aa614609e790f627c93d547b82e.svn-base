<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.com.oking.link.*"%>

<html>
  <head>  
    <title>tz</title>  
    
  </head>
  <body>
    <%
    	String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	String link=new String(request.getParameter("link").getBytes("ISO-8859-1"),"UTF-8");
	String type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
	
	linkAdd d=(linkAdd) ContextHolder.getApplicationContext()
			.getBean(linkAdd.class);
	int num=d.add(name,link , type);
	if(num>0){
		response.sendRedirect("close.jsp ");
	}else{
		System.out.println("添加链接出错");
	}
%>
     
  </body>
</html>
