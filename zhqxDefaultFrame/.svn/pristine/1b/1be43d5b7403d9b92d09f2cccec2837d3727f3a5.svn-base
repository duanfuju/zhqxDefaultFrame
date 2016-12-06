<%@page import="cn.com.oking.em.entity.EmJjtzFb"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.em.action.EmJjtzFbAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>紧急通知发布</title>
<script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
<style type="text/css">
tr:nth-child(odd){
	background-color: #ccc
}
.tr_first{
	font-size: 16px;
	font-weight: bold;
}
td{
	border: 1px solid #ccc;
}
.td01{
	width: 10%;
}

</style>
<%!
Object changNull(Object obj){
	String s = "-";
	if(obj != null ){
		return obj;
	}else{
		return s;
	}
}
%>
</head>
<body>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	EmJjtzFbAction action=(EmJjtzFbAction) ContextHolder.getApplicationContext().getBean(EmJjtzFbAction.class);
	List<EmJjtzFb> list=action.getData();
%>
		<table style="width: 100%;text-align: center">
        	<tr class="tr_first">
        			<td class='td01'>紧急通知主题</td>
        			<td class='td01'>灾害类型</td>
        			<td class='td01'>状态</td>
        			<td class='td01'>建立人</td>
        			<td class='td01'>建立时间</td>
        			<td class='td01'>批准人</td>
        			<td class='td01'>批准时间</td>
	        		<td class='td01'>发布</td>
        			<td class='td01'>发布时间</td>
        			<td class='td01'>操作</td>
        	</tr>
        	<%
        	if(list.size()==0){
        		out.print("<tr>");
                out.print("<td colspan='10'><h1>请先到紧急通知建议生成通知</h1></td>");
               	out.print("</tr>");
        	}else{
	        	for(int i=0;i<list.size();i++){	
	        		EmJjtzFb em=list.get(i);
	        		out.print("<tr>");
	                out.print("<td class='td01'>"+changNull(em.getSubject())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getZhlx())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getStatus())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getCreateby())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getCreatedate())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getAppby())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getAppdate())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getPubby())+"</td>");
	                out.print("<td class='td01'>"+changNull(em.getPubdate())+"</td>");
	                out.print("<td class='td01'><a href='"+basePath+"pageoffice/pdf/jjtz"+em.getId()+".pdf')'>查看pdf</a></td>");
	               	out.print("</tr>");
	        	}
        	}
        	%>
        </table>

</body>
</html>