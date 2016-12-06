<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	function sub(){
		 var n1=document.getElementById("n1").value;
		 var n2=document.getElementById("n2").value;
		if(n1==""){
			alert("请输入网站名称");
			return false;
		}
		 if(n2==""){
			alert("请输入网站链接");
			return false;
		}
	}
	<%
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
	%>
	$(function(){
		if("<%=id%>"){
			$("#type").attr('value',"<%=id%>");
		}
	}); 
	
</script>
</head>

<body style="margin:0 auto">
<div style="width:700px; height:180px;">
	<div style="width:700px; height:40px; line-height:0px; float:left;">
		<span><h4>添加网址</h4></span>
	</div>
	<div style="width:700px; height:80px; line-height:80px; float:left; background-color:#F0F0F0;border:1px solid #d0d0d0">
		<form action="tz.jsp"  method="post" style="margin-left:30px;" onsubmit="return sub()">
		<input id="n1" name="name" type="text" style="width:150px; height:25px; line-height:0px;" />
		<input id="n2" name="link" type="text" style="width:250px; height:25px; line-height:0px;" />
		<input type="hidden"  name="type" id="type" value=""  />
		<div style=" width:50px; float:right; margin-top:25px; margin-right:80px;">
		<input   type="submit"  style="background-image:url(images/tjwz.png); width:100px; height:30px; border:0px; " value="" />
		</div>
		</form>
	</div>
</div>
</body>
</html>
