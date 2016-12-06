<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="cn.com.oking.nrfb.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link href="../css/nrfb_sub.css" rel="stylesheet" type="text/css" />
<title>hello</title>
</head>
<body>
	<table class="list">
		<!-- <tr>
			<th width="60%">网站标题</th>
			<th width="20%">发布时间</th>
		</tr> -->
		<%%>
		<c:forEach var="news" items="${newslist}" varStatus="state">
			<tr>
				<td>${news.wzbt}</td>
				<td>${news.fbsj}</td>
			</tr>
		</c:forEach>


	</table>
	<div class="pager">
		<%
			request.setCharacterEncoding("utf-8");
			Integer currentPage = (Integer) session
					.getAttribute("currentPageN");
			Integer allPages = (Integer) session.getAttribute("allPages");
			String mid = session.getAttribute("mid").toString();
		%>
		<%-- <div style="">
			<label style="">第<%=currentPage%>页
			</label> <label style="">共<%=allPages%>页
			</label>
		</div> --%>
		<div class="menu">
			<ul class="clearfix" id="pageIndexCom">
				<li class="page_li">第<%=currentPage%>页/共<%=allPages%>页</li>
				<li><a href="../getInfoServlet?currentpage=1&mid=<%=mid%>">首页</a></li>
				<li><a
					href="../getInfoServlet?currentpage=<%=currentPage - 1%>&mid=<%=mid%>">上一页</a></li>
				<li><a
					href="../getInfoServlet?currentpage=<%=currentPage + 1%>&mid=<%=mid%>">下一页</a></li>
				<li><a
					href="../getInfoServlet?currentpage=<%=allPages%>&mid=<%=mid%>">尾页</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
