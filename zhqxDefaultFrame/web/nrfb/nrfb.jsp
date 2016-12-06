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
<link href="../css/nrfb/nrfb.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jQuery1.7.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/custominput.js"></script>
<script type="text/javascript">
	$(function() {
		$('input').customInput();

		$('.toggle').each(function() {
			$('div:first', this).addClass('first');
			$('div:last', this).addClass('last');
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var $tab_li = $('#tab ul li');
		$tab_li.click(function() {
			$(this).addClass('selected').siblings().removeClass('selected');
			var index = $tab_li.index(this);
			$('div.tab_box > div').eq(index).show().siblings().hide();

		});
	});
	function select(link, params) {
		//alert(link+"------"+params);
		document.getElementById("tab_frame").src = link + "?" + params
				+ "&currentpage=1";
	};
</script>
<%
	String uid = new String(request.getParameter("uid").getBytes(
			"ISO-8859-1"), "UTF-8");
	getTab d = (getTab) ContextHolder.getApplicationContext().getBean(
			getTab.class);
	List<Map<String, Object>> btlist = null;
	btlist = d.getList(uid);
%>

<style type="text/css">
#null_fj {
	margin-top: 50px;
	width: 500px;
	text-align: center;
}
</style>

</head>

<body style="overflow:-Scroll;overflow-y:hidden">
	<div id="all_div">
		<%
			if (btlist.size() > 0) {
		%>
		<div id="tab">
			<div style="width: 33px; height: 5px; float: left"></div>
			<div style="float: left">

				<ul class="tab_menu">
					<li
						onclick="select('<%=btlist.get(0).get("link")%>','<%=btlist.get(0).get("params")%>')"
						class="selected"><%=btlist.get(0).get("tab_name")%></li>
					<%
						for (int i = 1; i < btlist.size(); i++) {
								Map<String, Object> vs = btlist.get(i);
					%>
					<li onclick="select('<%=vs.get("link")%>','<%=vs.get("params")%>')"><%=vs.get("tab_name")%></li>
					<%
						}
					%>
				</ul>

			</div>
		</div>
		<div>
			<iframe
				src="<%=btlist.get(0).get("link")%>?<%=btlist.get(0).get("params")%>&currentpage=1"
				frameborder="0" scrolling="no" id="tab_frame" height="100%"
				width="100%"></iframe>
		</div>
		<%
			} else {
		%>
		<label><div id="null_fj">菜单未配置，请配置菜单！</div></label>
		<%
			}
		%>
	</div>

</body>
</html>
