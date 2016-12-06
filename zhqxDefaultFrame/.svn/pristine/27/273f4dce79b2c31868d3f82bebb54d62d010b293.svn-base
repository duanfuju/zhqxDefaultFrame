<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bstek.bdf2.core.view.frame.main.MainFrame"%>
<%@ page import="com.bstek.bdf2.core.model.Url"%>
<%@ page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%
	final String XTLJ_MENU_ID = "3e234f61-36de-4d70-9cb1-42629c097d80";
	
	MainFrame main = (MainFrame) ContextHolder.getApplicationContext()
			.getBean(MainFrame.class);
	com.oking.core.frame.main.MainFrame main1 = (com.oking.core.frame.main.MainFrame) ContextHolder
			.getApplicationContext().getBean(
					com.oking.core.frame.main.MainFrame.class);
	String pid = request.getParameter("id");
	String mid = request.getParameter("m");
	Collection<Url> urls = main.loadMeunUrls(pid);
	Map<String, Object> map = main1.getUrl(pid);
	String url_name = "子菜单";
	String url_icon = "images/leftico1_01.png";
	if (!map.isEmpty()) {
		url_name = (String) map.get("name");
		if (map.get("icon") != null) {
			url_icon = (String) map.get("icon");
		}
	}
	url_icon = "images/leftico1_0"+mid+".png";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>子菜单</title>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<script type="text/javascript">
	function ShowMenu(obj, n) {
		var Nav = obj.parentNode;
		if (!Nav.id) {
			var BName = Nav.getElementsByTagName("ul");
			var HName = Nav.getElementsByTagName("h2");
			var t = 2;
		} else {
			var BName = document.getElementById(Nav.id).getElementsByTagName(
					"span");
			var HName = document.getElementById(Nav.id).getElementsByTagName(
					"h1");
			var t = 1;
		}
		for ( var i = 0; i < HName.length; i++) {
			HName[i].innerHTML = HName[i].innerHTML.replace("-", "+");
			//if(obj.tagName != "H2"){   }
			//HName[i].className = "";
		}
		obj.className = "h" + t;
		
		if(obj.tagName == "H2"){obj.className = "closeMenu";}
		//obj.className = "closeMenu";
		
		for ( var i = 0; i < BName.length; i++) {
			if (i != n) {
				BName[i].className = "no";
			}
		}
		if (BName[n].className == "no") {
			BName[n].className = "";
			obj.innerHTML = obj.innerHTML.replace("+", "-");
		} else {
			BName[n].className = "no";
			//obj.className = "";
			obj.innerHTML = obj.innerHTML.replace("-", "+");
		}
		
	}
	
	var oldid = "";
	function openMenu(id,hs) {
		
		if(oldid != null && oldid != ""){
			oldid.className = "closeMenu";
		}
		oldid = hs;
		var obj = hs;
		obj.className = "openMenu";
		top.window.openUrlInFrameTab(id);
	}
	
	function openMenuId(id,hs) {
		
		if(oldid != null && oldid != ""){
			oldid.className = "closeMenu";
		}
		var newObj = document.getElementById(id);
		
		oldid = newObj;
		newObj.className = "openMenu";
		top.window.openUrlInFrameTab(id);
	}
	
	
</script>
</head>
<body style="background:#C8EBFC;overflow-x:hidden;">
	<div id="menu">
		<div class="FD">
			<div
				style="position: absolute; height: 60px; width: 171px; background: url(images/leftbg04.png);"></div>
			<div class="minico">
				<img src="<%=url_icon%>" width="42" height="42">
			</div>
			<div class="titi"><%=url_name%></div>
		</div>
		<%
			int ms = 0;
			for (Url urlsub1 : urls) {
				List<Url> urls1 = urlsub1.getChildren();
				
				// 系统链接一级菜单不需要子菜单
				if(pid.equals(XTLJ_MENU_ID)) {
					out.println("<h1/>");
				}
				else {
					if (urls1.isEmpty()) {
						if (urlsub1.getUrl() != null && !"".equals(urlsub1.getUrl())) {
							out.println("<h1 onClick=\"javascript:openMenu('"
									+ urlsub1.getId() + "',this)\">");
						} else {
							out.println("<h1 onClick='javascript:void(0)' data-id='"+urlsub1.getId()+"'>");
						}
					} else {
						out.println("<h1 onClick='javascript:ShowMenu(this," + ms
								+ ")' data-id='"+urlsub1.getId()+"'>");
						ms++;
					}
				}
				
				String name = urlsub1.getName();
				if (name.length() > 6) {
					name = name.substring(0, 6) + "…";
				}
				out.println("<a href='javascript:void(0)'>");
				out.println("<div class='listico'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ name + "</div>");
				out.println("</a></h1>");
				
				// 系统链接一级菜单不需要子菜单
				if(pid.equals(XTLJ_MENU_ID)) {
					 continue;
				}
				
				if (!urls1.isEmpty()) {
					if (ms == 1) {
						out.println("<span class='yes'>");
					} else {
						out.println("<span class='no'>");
					}

					int n = 0;
					for (Url url1 : urls1) {
						String name1 = url1.getName();
						List<Url> urls2 = url1.getChildren();
						if (urls2.isEmpty()) {
							if (url1.getUrl() != null
									&& !"".equals(url1.getUrl())) {
								out.println("<h2  class='closeMenu' onClick=\"javascript:openMenu('"
										+ url1.getId() + "',this)\">");
							} else {
								out.println("<h2 class='closeMenu'  onClick='javascript:void(0)'>");
							}
							out.println("<a href='javascript:void(0)'>"
									+ url1.getName() + "</a></h2>");
						} else {
							
							out.println("<h2  class='closeMenu' onClick='javascript:ShowMenu(this,"
									+ n + ")'>");
							out.println("<a href='javascript:void(0)'>+ "
									+ url1.getName() + "</a></h2>");
							n++;
						}

						if (!urls2.isEmpty()) {
							out.println("<ul class='no'>");
							for (Url url2 : urls2) {
								String name2 = url2.getName();
								String path = url2.getUrl();
								String icon = url2.getIcon();
								out.println("<a id='"+url2.getId()+"'  class='closeMenu' href=\"javascript:openMenuId('"
										+ url2.getId() + "',this)\">" + url2.getName()
										+ "</a>");

							}
							out.println("</ul>");
						}
					}
					out.println("</span>");
				}
			}
		%>
	</div>
</body>
</html>