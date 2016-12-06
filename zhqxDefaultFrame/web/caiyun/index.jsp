<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.caiyun.getList"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.PrintStream" %>
<%@page import="java.text.SimpleDateFormat" %>

<%
	getList dao = (getList) ContextHolder.getApplicationContext().getBean(getList.class);
	List<Map<String, Object>> list=dao.newdate();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<![if !IE]>
<audio src='1689.mp3' autoplay="autoplay"></audio>
<![endif]>
<title>浦口天气 - 天气雷达,分钟降水预报,街道天气预报</title>
<style>
</style>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0;
	padding: 0
}

#map_canvas {
	height: 100%
}

#panel {
	position: absolute;
	bottom: 0;
	left: 0%;
	width: 100%;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	opacity: 0;
}



</style>
<script type="text/javascript">
	function openMenu(id) {
		top.window.openUrlInFrameTab(id);
	}
</script>
<meta name="description"
	content="">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=882, user-scalable=no">
<style type="text/css">
table.imagetable {
width:100%;
	font-family: '微软雅黑', '宋体', 'Times New Roman', 'Courier New';
	font-size:13px;
	border-width: 1px;
	border-collapse: collapse;
	text-align:center;
	
}
.hla{
background:#e7ebf1;
font-size:13px;
	border-width: 1px;
	border-color:#c5d9e9;
	padding: 8px;
	text-align:center;
	border-style: solid;
}
.hla1{
background:#f5f7f9;
	border-width: 1px;
	font-size:13px;
	text-align:center;
	padding: 8px;
	border-style: solid;
	border-color: #c5d9e9;
}
table.imagetable th {
	background:#e7ebf1;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color:#c5d9e9;
}


</style>
</head>
<body onLoad="getStationInfoThenInit()" class="desktop chrome forecast">

				
				    <div id="overview" class="overview_container precip rain"
					style="visibility: visible;">
					<div class="inner"
						style="background: white; display: table; opacity: 0.9; padding-left: 10px; padding-right: 10px; vertical-align:middle; border: 1px solid #ddd; border-radius: 10px;">
						    <div style="min-width:200px; height:170px;">
							<%
								if(list.size()>0){
							%>
								<table id="hla" class="imagetable">
									<%
									for (Map<String,Object> map : list) {
										Object description=map.get("description");		
										Object longitude=map.get("longitude");
										Object latitude=map.get("latitude");
										Object id=map.get("id");
										Object result="?"+id+"#"+longitude+","+latitude;
									%>
									<tr>
										<td><a href="javascript:void(0)"  onClick="openMenu('<%=result%>')"  style="text-decoration:none;"><%=description %></a></td>
									</tr>
									<%} %>
								</table>
							<%}else{%>
							
								<img src="none.png" height="120px" width="180px" style=" margin-top:3px"/>
							<%}%>
							</div>
					</div>
					<div style="clear: left"></div>
				</div>
</body>
</html>

