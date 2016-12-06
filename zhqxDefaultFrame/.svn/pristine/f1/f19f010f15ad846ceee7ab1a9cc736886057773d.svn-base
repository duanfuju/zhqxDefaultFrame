<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bstek.bdf2.core.view.frame.main.MainFrame"%>
<%@ page import="com.bstek.bdf2.core.model.Url"%>
<%@ page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%
MainFrame main = (MainFrame) ContextHolder.getApplicationContext()
.getBean(MainFrame.class);
//String pid = request.getParameter("ID");
Collection<Url> urls = main.loadMeunUrls(null);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浦口智慧气象工作平台</title>
<link rel="stylesheet" type="text/css" href="css/all.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<!--[if IE 6]>
		<style>body{behavior:url(js/csshover3.htc);}</style>
		<script src="js/DD_belatedPNG.js"></script>
		<script>
			DD_belatedPNG.fix('div,span,li,img,i,em,table,b');
		</script>
<![endif]-->
<!--DD_belatedPNG.fix('.png_bg, img')中".png_bg"为要插入png背景图的class或者id,"img"为要插入png图片-->
<style type="text/css">
	tr.t1 td {background-color:#fff;}/* 交替行第一行的背景色 */
	tr.t2 td {background-color:#f4f4f4;}/* 交替行第二行的背景色 */
	tr.t3 td {background-color:#e2e0e0; color:#000000;}/* 鼠标经过*/
	.bor{border:1px solid #37bff1; background:url(images/20150105index_28.png) repeat-x; color:#FFF; height:28px;}
	.time{font-family:"Arial", "Helvetica", "sans-serif";}
tbody.line td{
	border:1px solid #37bff1;/*细线条颜色*/
	height:26px;
	}
</style>
<script type="text/javascript" src="js/tab.js"></script>
</head>
<body>
<div id="leftall">
	<div class="left_ico">
        <div class="maxico">
            <ul>
					<%
						int m=1;
						int size=urls.size();
						for (Url url : urls){
							String buttonClass = (m==1) ? "onbutton":"button";
							String icon = url.getIcon();
							if(icon == null || "".equals(icon)){
								icon="images/leftico_01.png";
							}
							String name =url.getName();
							icon="images/leftico_0"+m+".png";
							%>
						<li><div class="<%=buttonClass %>" id="b1_button<%=m %>"
								onclick="changepart('b1',<%=m %>,<%=size %>)">
								<span><img src="<%=icon %>" alt="" width="45" height="43" />
								</span>
								<div class="tittl"><%=name %></div>
							</div>
						</li>
						<%
							m++;
						}
						%>
            </ul>
        </div>
    </div>
	<div class="inner">
			<div class="menu">
				<%
					m=1;
					for (Url url : urls){
						String style = (m==1) ? "":"none";
						String id = url.getId();
						System.out.println("------");
				%>
					<!-- <iframe frameBorder="0" src="menu.jsp?id=<%=id %>&m=<%=m %>"
						 id="b1_part<%=m %>" name="carnoc<%=m %>"  class="t" id="b1_part<%=m %>"  scrolling="auto"
						 style="display: <%=style %>; height:98%;" ></iframe> -->
						 
						 <div class="t" id="b1_part<%=m %>" style="display: <%=style %>; height:100%;">
					<iframe frameBorder="0" src="menu.jsp?id=<%=id %>&m=<%=m %>"
						id="carnoc<%=m %>" name="carnoc<%=m %>" scrolling="auto" 
						style="height: 98%; overflow: hidden; VISIBILITY: inherit; WIDTH: 184px; Z-INDEX: <%=m %>"></iframe>
				</div>
						 
						  <!-- style="height: 98%; overflow: hidden; VISIBILITY: inherit; WIDTH: 184px; Z-INDEX: <%=m %>" -->
				<%
						m++;
					}
					%>
				<div class="clear_after"></div>
			</div>
	</div>
</div>
</body>
</html>
