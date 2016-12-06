<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.waterMonitoring.action.WaterDataAction"%>
<%@page import="com.bstek.dorado.core.Configure"%>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%
Object mon="";
Object monTime="";
Object quarter="";
Object quarterTime="";
Object year="";
Object yearTime="";
Object max="";
Object maxTime="";
Object error=null;
try{
	WaterDataAction action = (WaterDataAction) ContextHolder.getApplicationContext()
			.getBean(WaterDataAction.class);
				String id=request.getParameter("siteid");
				List<Map<String, Object>> data=action.getData3(id);
				for (Map<String, Object> map : data) {
					if (map.get("wdId").equals("month")) {
						mon=map.get("wdResults");
						monTime=map.get("wdDate");
					}else if(map.get("wdId").equals("quarter")){
						quarter=map.get("wdResults");
						quarterTime=map.get("wdDate");
					}else if(map.get("wdId").equals("year")){
						year=map.get("wdResults");
						yearTime=map.get("wdDate");
					}else if(map.get("wdId").equals("max")){
						max=map.get("wdResults");
						maxTime=map.get("wdDate");
					}
				}
}catch(Exception e){
	error=e;
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
<!--
.datalist{
	border:1px solid #0058a3;	/* 表格边框 */
	font-family:Arial;
	border-collapse:collapse;	/* 边框重叠 */
	background-color:#eaf5ff;	/* 表格背景色 */
	font-size:18px;
}
.datalist caption{
	padding-bottom:5px;
	font:bold 1.4em;
	text-align:left;
}
.datalist th{
	border:1px solid #0058a3;	/* 行名称边框 */
	background-color:#D8E2E6;	/* 行名称背景色 */
	/*color:#FFFFFF;				 行名称颜色 */
	font-weight:bold;
	padding-top:8px; padding-bottom:8px;
	padding-left:12px; padding-right:12px;
	text-align:center;
}
.datalist td{
	border:1px solid #0058a3;	/* 单元格边框 */
	text-align:center;
	padding-top:8px; padding-bottom:8px;
	padding-left:10px; padding-right:10px;
}
.datalist tr{
	background-color:#FFFFFF;	/* 隔行变色 */
}
.datalist tr.altrow{
	background-color:#EEEEEE;	/* 隔行变色 */
}
-->
</style>
</head>
<body>
	<center>
	<table class="datalist" width="95%" >
	    	<% 
	    		if(error!=null){
	    	%>
	    		
		    		<h1>请联系管理员</h1>
	    		
	    	
	    	<%
	    		}else{
	    		%>
			    	<tr>
						<th scope="col">历史时间</th>
						<th scope="col">最大深度(cm)</th>
						<th scope="col">发生时间</th>
			    	</tr>
			    	 <tr >
				    	<td>最近30天</td>
				    	<td><%=mon %></td>
				    	<td><%=monTime%></td>
			    	</tr>
			    	<tr class="altrow">
				    	<td>最近1季度</td>
				    	<td><%=quarter%></td>
				    	<td><%=quarterTime%></td>
			    	</tr>
			    	<tr >
				    	<td>最近1年</td>
				    	<td><%=year%></td>
				    	<td><%=yearTime%></td>
			    	</tr>
			    	<tr class="altrow">
				    	<td>历史最大值</td>
				    	<td><%=max%></td>
				    	<td><%=maxTime%></td>
			    	</tr>
	    		<%
	    		}
	    	%>
	    	
    </table>
    </center>
</body>
</html>
