<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="cn.com.oking.nrfb.*"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel=stylesheet type=text/css href="../css/nrfb/contxt.css" />
<link rel=stylesheet type=text/css href="../css/nrfb/nrfb_sub.css" />
<%
	String mid = new String(request.getParameter("mid").getBytes(
			"ISO-8859-1"), "UTF-8");
	String currentPageStr = new String(
			request.getParameter("currentpage"));
	getWzWz d = (getWzWz) ContextHolder.getApplicationContext()
			.getBean(getWzWz.class);
	List<Map<String, Object>> btlist = new ArrayList<Map<String,Object>>();
	int curpage = 0;
	int allpage = 0;
	int allcount = 0;
	int pagesize = 0;
	String check = "";

	btlist = d.getReady(mid, currentPageStr);
	curpage = Integer.parseInt(btlist.get(0).get("curpage").toString());
	allpage = Integer.parseInt(btlist.get(0).get("allpage").toString());
	allcount = Integer.parseInt(btlist.get(0).get("allcount")
			.toString());
	pagesize = Integer.parseInt(btlist.get(0).get("pagesize")
			.toString());
%>
<style>
table {
	
}

td {
	line-height: 24px;
	font-size: 13px;
}

td a {
	font-size: 13px;
	margin-left: 0px;
	text-decoration: none
}

#text {
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 640px;
	overflow: hidden;
}

#text a {
	color: #000000;
}

#text a:hover {
	text-decoration: none;
	color: #0066FF;
}
#null_fj {
	margin-top:50px;
	width:500px;
	text-align: center;
}
</style>
</head>
<body style="background-color: #ecfafb; OVERFLOW: hidden;">
	<div style="width: 100%; OVERFLOW: hidden;">
		<div
			style="WIDTH: 100%; DISPLAY: block; OVERFLOW: hidden; margin-left: -30px;"
			id=pageContent class=hide>
			<div class=pagecContxt  width="100%"> 
				<%
					if (allcount > 0) {
				%>
				<div  width="800px">
					<ul id=ullist  width="800px">
						<%
							for (int i = 0; i < btlist.size(); i++) {
									Map<String, Object> vs = btlist.get(i);
									String title = vs.get("wzbt").toString();
									String wzbh = vs.get("wzbh").toString();
									String fjbm = vs.get("fjbm").toString();
									String time = vs.get("fbsj").toString();
						%>
						<li>

							<table width="800px" border="0" cellspacing="0" cellpadding="8">
								<tr>
									<td width="11">&nbsp;</td>
									<td width="600px"><div id="text">
											<a href="show_fj.jsp?fjbm=<%=fjbm%>&title=<%=title%>" target="_blank"><img
												style="border: 0px;" width="7" height="7"
												src="../images/nrfb/icona.jpg" />&nbsp;<%=title%></a>
										</div></td>
									<td width="150px"><%=time%></td>
								</tr>
							</table>
						</li>
						<%
							}
						%>
					</ul>
				</div>
				<%
					} else {
				%>
				<label><div id="null_fj">无内容</div></label>
				<%
					}
				%>
			</div>
			<table style="margin: 0 auto">
				<tr>
					<td width=100% colspan=4 align="center" style="font-size: 13px;">
						页次<%=curpage%>/<%=allpage%>&nbsp;&nbsp;共<%=allcount%>条&nbsp;&nbsp;<%=pagesize%>条/页
						<a href="nrfb_sub_two_column.jsp?mid=<%=mid%>&currentpage=1">首页</a>
						<a
						href="nrfb_sub_two_column.jsp?mid=<%=mid%>&currentpage=<%=(curpage - 1)%>">上页</a>
						<a
						href="nrfb_sub_two_column.jsp?mid=<%=mid%>&currentpage=<%=(curpage + 1)%>">下页</a>
						<a
						href="nrfb_sub_two_column.jsp?mid=<%=mid%>&currentpage=<%=allpage%>">末页</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</div>
</body>
</html>
