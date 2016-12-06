<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="cn.com.oking.link.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>列表页</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<script>
		function h1(i){
			var ii="tj"+i;
			document.getElementById(ii).src="images/ctj.png";
		};
		function h2( i){
			var ii="tj"+i;
			document.getElementById(ii).src="images/tj.png";
		};
		function b1(i){
			var ii="bj"+i;
			document.getElementById(ii).src="images/cbj.png";
		};
		function b2(i){
			var ii="bj"+i;
			document.getElementById(ii).src="images/bj.png";
		};
		
</script>
 <style> 
        .black_overlay{ 
            display: none; 
            position: absolute; 
            top: 0%; 
            left: 0%; 
            width: 100%; 
            height: 100%; 
            background-color: black; 
            z-index:1001; 
            -moz-opacity: 0.8; 
            opacity:.80; 
            filter: alpha(opacity=88); 
        } 
        .white_content { 
            display: none; 
            position: absolute; 
            top: 25%; 
            left: 20%; 
            width: 740px; 
            height: 190px; 
            padding: 20px; 
            border: 4px solid #3da1ff; 
            background-color: white; 
            z-index:1002; 
            overflow: auto; 
        } 
    </style> 
<body>

<div style="width:100%; height:100%">

<div id="light" class="white_content">
				 <a style="float:right"  href = "javascript:void(0)" onclick = "returnIndex()">返回</a>
			 <iframe src="" id="iframenum" style="width:730px; height:170px; margin-left:1px; margin-top:2px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
		</div> 
        <div id="fade" class="black_overlay"></div> 
        
<script>
function returnIndex(){
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none';
	location.reload(true);
}
function addIframe(id){
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block';
	document.getElementById('light').scrollIntoView(false);
	$("#iframenum").attr("src","add.jsp?id="+id);
}
function editIframe(id){
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block';
	document.getElementById('light').scrollIntoView(false);
	$("#iframenum").attr("src","edit.jsp?id="+id);
}

</script>
  <%
  String menuid=new String(request.getParameter("menuid").getBytes("ISO-8859-1"),"UTF-8");
  getModule d=(getModule) ContextHolder.getApplicationContext()
	.getBean(getModule.class);
  
  List<Map<String, Object>> list=d.getList(menuid);
  for(int i=0; i<list.size();i++){
	  Map<String, Object> vs=list.get(i);
	  String modulename=vs.get("modulename").toString();
	  String id=vs.get("id").toString();
	  String colnum=vs.get("colnum").toString();
	  
	  getHrefItem g=(getHrefItem) ContextHolder.getApplicationContext()
				.getBean(getHrefItem.class);
	  List<Map<String, Object>> linklist=g.getList(id);
  
  %>  
  <style>

.content{
	margin: 0px auto;
	width: 60%;
}
.tontent_top{
	width: 100%;
}

li{
	float:left;
	list-style:none;
	padding:10px 10px;
	width:29%;
	height:40%;
	text-align:center;
}
.clearfloat{clear:both;height:0;font-size: 1px;line-height: 0px;} 
a{text-decoration:none;width: 100%}
a:hover{color:#3300FF}
</style>
<!--模块1-->
<div class="content" style=" margin-bottom:10px;">
	<div class="tontent_top">
		<span style="font-weight:bold"> <%=modulename %></span>
		<span style="float:right">
		 	<a><img id="tj<%=i %>"  src="images/tj.png" width="60" height="20" onmouseover="h1(<%=i %>)" onmouseout="h2(<%=i %>)"  onclick = "addIframe(<%=id %>)" /></a>
			<a><img id="bj<%=i %>"  src="images/bj.png" width="60" height="20" onmouseover="b1(<%=i %>)" onmouseout="b2(<%=i %>)" onclick = "editIframe(<%=id %>)" /></a>
		</span>
	</div>
<div style="width:100%;height:60px;min-height:60px; height:auto!important; border:1px solid #d0d0d0">

	<ul>
		<%
			for(int j=0;j<linklist.size();j++){
				 Map<String, Object> vs1=linklist.get(j);
				String itemname=vs1.get("itemname").toString();
				String itemurl=vs1.get("itemurl").toString();
				String opentype=vs1.get("opentype").toString();
		%>
		<li><a href="<%=itemurl%>" target="<%=opentype%>"><%=itemname %></a></li>
		<%} %>
		<div class="clearfloat"></div>
	</ul>
</div>
</div>
<%} %>

</div>
</body>
</html>
