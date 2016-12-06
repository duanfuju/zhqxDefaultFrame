<%@page import="cn.com.oking.fzjz.entity.MnylCommonlink"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.fzjz.action.MnylCommonlinkAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>常用链接</title>
<%
	String roleId=new String(request.getParameter("roleId").getBytes("ISO-8859-1"),"UTF-8");
	//因为tomcat中为项目配置过中文路径，所以在本地运行时使用需要转码，而服务器上运行时不需要
	//String roleId=request.getParameter("roleId");
	MnylCommonlinkAction action=(MnylCommonlinkAction) ContextHolder.getApplicationContext().getBean(MnylCommonlinkAction.class);
	List<MnylCommonlink> list=action.findByRoleId(roleId);
%>
</head>
<body>
	<ul style="list-style:none;">
		<%
			for(MnylCommonlink m :list){
		%>
				<li style="border: 1px dashed #CCC;border-left:0px;border-right:0px;border-top:0px; width: 80px;height: 30px;line-height: 30px" ><span style="color: orange;">★</span><a style=" text-decoration:none; color:blue" href="<%=m.getLinkLocation() %>" target="_blank"><%=m.getLinkName() %></a></li>
		<%
			}
		%>
	</ul>
</body>
</html>