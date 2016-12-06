<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.em.action.EmModeContentAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../../css/templateStyle.css" />
<script type="text/javascript" src="../../js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../../js/index_zhjc.js"></script>
<style type="text/css">
tr{
	width: 100%;
	height: 30%
}
td{
	width: 200px;
	height: 40%;
}
</style>

</head>
<body>
		<div id="flashContent" style="display:none">
		</div>
        <%
  	String dm_id=new String(request.getParameter("dm_id").getBytes("ISO-8859-1"),"UTF-8");
	EmModeContentAction action=(EmModeContentAction) ContextHolder.getApplicationContext()
	.getBean(EmModeContentAction.class);
  	List<Map<String, Object>> list=action.getDataByDmId(dm_id);
  	String state="";
  	//如果数据集的数量不够的话增加默认图片提示
  	for(int i=list.size();i<=19;i++){
  		Map<String,Object> map=new HashMap<String,Object>();
  		map.put("url", "../../images/close2.gif");
  		list.add(map);
  	
  	}
  %> 
     
        <div id="info0" style="display:none;">
        	<!-- 左边的 -->
        	<div style="left:0px; top:0px"><iframe src="<%=list.get(0).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(0).get("url").toString() %>"></p></div>
        	<div style="left:16.6%; top:0px"><iframe src="<%=list.get(1).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(1).get("url").toString() %>"></p></div>
        	<div style="left:0px; top:33.3%;"><iframe src="<%=list.get(2).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(2).get("url").toString() %>"></p></div>
        	<div style="left:16.6%; top:33.3%;"><iframe src="<%=list.get(3).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(3).get("url").toString() %>"></p></div>
        	<div style="left:0px; top:66.6%;"><iframe style="text-align:center" src="<%=list.get(4).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(4).get("url").toString() %>"></p></div>
        	<div style="left:16.6%; top:66.6%;"><iframe style="text-align:center" src="<%=list.get(5).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(5).get("url").toString() %>"></p></div>
            
            <!-- 中间底下的小的第一行-->
        	<div style="left:33.2%; top:66.6%;"><iframe src="<%=list.get(12).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(12).get("url").toString() %>" ></p></div>
        	<div style="left:49.8%; top:66.6%;"><iframe src="<%=list.get(13).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(13).get("url").toString() %>" ></p></div>

            <!-- 右边的 -->
        	<div style="left:66.4%; top:0px;"><iframe src="<%=list.get(6).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(6).get("url").toString() %>"></p></div>
        	<div style="left:83%; top:0px; width:17%;"><iframe src="<%=list.get(7).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(7).get("url").toString() %>"></p></div>
        	<div style="left:66.4%; top:33.3%;"><iframe src="<%=list.get(8).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(8).get("url").toString() %>"></p></div>
        	<div style="left:83%; top:33.3%;width:17%;"><iframe src="<%=list.get(9).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(9).get("url").toString() %>"></p></div>
        	<div style="left:66.4%; top:66.6%;"><iframe src="<%=list.get(10).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(10).get("url").toString() %>"></p></div>
        	<div style="left:83%; top:66.6%; width:17%;"><iframe src="<%=list.get(11).get("img_src").toString() %>" frameborder="0" scrolling="no"></iframe><p to="<%=list.get(11).get("url").toString() %>"></p></div>
           
        </div>
        
        
        <div id="info">
        	<div id="infoContent"></div>
            <img src="images/homeBtn.png" id="homeBtn" style="display:none"/>
        	<div id="big" style="left:33.2%; top:0;">
            	<iframe id="bigIframe" name="bigIframe" src="" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
            </div>
             <div id='moreIcon'  style="display:none;overflow-y:auto;top:66.6%;left:33.2%;width: 33.2%;height: 33.4%;position: relative;z-index:100;">
            	<div style="width: 100%;height: 20px;display:block;position: static;"><a style="float:right"  href = "javascript:void(0)" onclick = "returnIndex()">关闭</a>	</div>
            	<%
            		for(int i=20;i<list.size();i++){
            	%>
            		<div style="border:1px solid green;width:32%;height:52%;float: left;position: static;" ><iframe  class='block' src="<%=list.get(i).get("url").toString() %>" style="display:block;" frameborder="0" scrolling="no"  ></iframe><p style="" to="<%=list.get(i).get("url").toString() %>" ></p></div>
            	<%
            		}
            	%>
            </div>
        </div>
        
	</body>
	<script type="text/javascript">
	function returnIndex(){
		document.getElementById('moreIcon').style.display='none';
		location.reload(true);
	}
	function showMore(){
		document.getElementById('moreIcon').style.display='block';
	}
	</script>
</html>