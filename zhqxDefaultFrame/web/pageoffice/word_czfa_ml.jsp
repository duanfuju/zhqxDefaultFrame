<%@page import="com.zhuozhengsoft.pageoffice.wordwriter.Table"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="cn.com.oking.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="com.zhuozhengsoft.pageoffice.wordwriter.DataRegion"%>
<%@page import="com.zhuozhengsoft.pageoffice.wordwriter.WordDocument"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.zhuozhengsoft.pageoffice.*;" %>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>czfa_ml</title>
<script type="text/javascript">
		function Save() {
		    document.getElementById("PageOfficeCtrl1").WebSave();
		    //document.getElementById("PageOfficeCtrl1").CustomSaveResult获取的是保存页面的返回值
			//alert("保存成功，返回值为：" + document.getElementById("PageOfficeCtrl1").CustomSaveResult);
		    alert("保存成功");
		}
		 function SetFullScreen() {
	            document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;
	    }
</script>
</head>
<body>
<%
try{
	//根据传递的id获取响应命令的信息
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);  
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.do"); //此行必须
	

	//隐藏菜单栏
	poCtrl1.setOfficeToolbars(true);
	poCtrl1.setMenubar(true);
	//隐藏工具栏
	poCtrl1.setCustomToolbar(true);
	
	//添加自定义按钮,第三个数字参数代表图片
	poCtrl1.addCustomToolButton("保存","Save()",1);
	poCtrl1.addCustomToolButton("全屏", "SetFullScreen()", 4);
	//设置保存页面 
	poCtrl1.setSaveFilePage("savefile.jsp");  
	
	poCtrl1.setCaption("处置方案");
	String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") + "\\doc\\";
	//打开Word文档
	poCtrl1.webOpen(path+"czfa"+id+".doc", OpenModeType.docNormalEdit, "张三");   
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
}catch(Exception e){
	%>
<script type="text/javascript">

	alert("没有word文件，请先检查是否操作错误或请先联系管理员");

</script>

	<%
}
%>
<div style="width: 100%;height: 800px;">
	<po:PageOfficeCtrl id="PageOfficeCtrl1" />
</div>
</body>
</html>