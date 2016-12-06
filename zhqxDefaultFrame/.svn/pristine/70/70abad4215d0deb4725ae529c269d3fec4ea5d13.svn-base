<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.action.ZqscAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html">
<html>
<head>
<%!
String changNull(Object obj){
	String s = "-";
	if(obj != null ){
		s = (String)obj;
	}
	return s;
}
%>
<%
    try{
    	ZqscAction action=(ZqscAction) ContextHolder.getApplicationContext().getBean(ZqscAction.class);
    	List<Map<String, Object>> list_sqpt=action.getDataBySqpt();
    	List<Map<String, Object>> list_phone=action.getDataByPhone();
     	
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width = device-width,initial-scale=1">
<title>灾情上传</title>
<link type="text/css" href="../js/jquery.mobile-1.4.5.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="../js/jquery.mobile-1.4.5.min.js"></script>
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
.td02{
	width: 20%;
}
.black_overlay{ 
           display: none; 
           position: relative; 
           width: 100%; 
           height: 100%; 
           background-color: black; 
           z-index:1001; 
           filter: alpha(opacity=88); 
} 
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".imgClick").click(function(){
		$("#imgMax").attr("src",$(this).attr("src"));
		document.getElementById('fade').style.display='block';
		scroll(0,0);  
	});
	$("#imgMax").click(function(){
		document.getElementById('fade').style.display='none';
	});
});
</script>
</head>
<body>
<div id="fade" class="black_overlay">
	<img id="imgMax" src="" width="100%" height="100%"/>
</div> 
<div data-role="page" id="pageone">
        <div data-role="header" >
            <h1>图片展示</h1>
        </div>
        <div role="main" >
        <table style="width: 100%;text-align: center">
        	<tr class="tr_first">
        			<td class='td01'>图标</td>
	        		<td class='td01'>时间</td>
	        		<td class='td01'>街道</td>
	        		<td class='td01'>社区</td>
	        		<td class='td01'>地点</td>
	        		<td class='td01'>灾害种类</td>
	        		<td class='td01'>灾情描述</td>
	        		<td>图片</td>
        	</tr>
        	<%
        		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        	for(int i=0;i<list_sqpt.size();i++){
        		Map<String,Object> map=list_sqpt.get(i);
        		out.print("<tr>");
        		out.print("<td class='td01'><img src='computer.png'/></td>");
        		String time=sdf.format(map.get("uptime"));
                out.print("<td class='td01'>"+time+"</td>");
                out.print("<td class='td01'>"+changNull(map.get("streetname"))+"</td>");
                out.print("<td class='td01'>"+changNull(map.get("communityname"))+"</td>");
                out.print("<td class='td01'>"+changNull(map.get("addressname"))+"</td>");
                out.print("<td class='td01'>"+changNull(map.get("disastertype"))+"</td>");
                out.print("<td class='td02'>"+changNull(map.get("other"))+"</td>");
                out.print("<td><img class='imgClick' src='/zqsc/sqptPath\\"+map.get("realname").toString()+"'width='200px' height='120px'/></td>");
                out.print("</tr>");
        	}
        	%>
        	<%
	        	for(int i=0;i<list_phone.size();i++){
	        		Map<String,Object> map=list_phone.get(i);
	        		out.print("<tr>");
	        		out.print("<td class='td01'><img src='phone.png'/></td>");
	        		String time=sdf.format(map.get("time"));
	                out.print("<td class='td01'>"+time+"</td>");
	                out.print("<td class='td01'>"+changNull(map.get("street"))+"</td>");
	                out.print("<td class='td01'>"+changNull(map.get("community"))+"</td>");
	                out.print("<td class='td01'>"+changNull(map.get("address"))+"</td>");
	                out.print("<td class='td01'>"+changNull(map.get("disaster"))+"</td>");
	                out.print("<td class='td02'>"+changNull(map.get("description"))+"</td>");
	                out.print("<td><img class='imgClick' src='/zqsc/phonePath/"+map.get("file_name").toString()+"'width='200px' height='120px'/></td>");
	                out.print("</tr>");
	        	}
	        	
	        	%>
        </table>
        
        </div>
        <div data-role="footer">
            <h1><!-- 这个是底部 --></h1>
        </div>
    </div>
<%
     }catch(Exception e){
            System.out.println(e.getMessage());
     }
%>
</body>
</html>