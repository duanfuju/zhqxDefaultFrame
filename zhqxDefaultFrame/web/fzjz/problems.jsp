<%@page import="cn.com.oking.fzjz.entity.MnylProblems"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.fzjz.action.MnylProblemsAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问题界面</title>
<%
	String zhCase=request.getParameter("zhCase");
	String zhId=request.getParameter("zhId");
	String drillMode=request.getParameter("drillMode");
	String roleSelection=request.getParameter("roleSelection");
	String dept=request.getParameter("dept");
	String ylId=request.getParameter("ylId");
	
	MnylProblemsAction action=(MnylProblemsAction) ContextHolder.getApplicationContext().getBean(MnylProblemsAction.class);
	List<MnylProblems> list=action.findByWhere(zhId, zhCase, drillMode, roleSelection, dept);
	
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	

%>
<style type="text/css">
*{  
	  scrollbar-face-color:#01b9f6; /*面子*/  
	  scrollbar-arrow-color:#fff; /*箭头*/  
	  scrollbar-3dlight-color:#e9f1d2; /*最外左*/  
	  scrollbar-highlight-color:#e9f1d2; /*左二*/  
	  scrollbar-shadow-color:#e9f1d2; /*右二*/  
	  scrollbar-darkshadow-color:#e9f1d2; /*右一*/  
	  scrollbar-track-color:#e9f1d2; /*滑道*/  
}

/*滚动条整体*/  
::-webkit-scrollbar{  
    width:12px; /*滚动条宽度*/  
}  
/*滚动条按钮*/  
::-webkit-scrollbar-button {  

}  
::-webkit-scrollbar-track{  
    background-color: #e9f1d2;  /*滑道全部*/  
}  
::-webkit-scrollbar-track-piece{  
    background-color:#c7dce3;  /*滑道*/  
    -webkit-border-radius:1px; /*滑道圆角宽度*/  
}  
::-webkit-scrollbar-thumb{  
   background:#01b9f6; /*滑动条表面*/  
    /*滑动条边框*/  
    border-radius:8px;/*滑动条圆角宽度*/ 
}  
/*横竖滚动条交角*/  
::-webkit-scrollbar-corner {  
    background-color: #0380f5;  
}  
/*横竖滚动条交角图案*/  
::-webkit-resizer {  
    background-repeat: no-repeat;  
    background-position: bottom right;  
}  
/*鼠标滑过滑动条*/  
::-webkit-scrollbar-thumb:hover{  
    background:#009dd2; 
} 
body{
	text-align: center;
	margin: 0 auto;
	font-size:15px;
}
ul{
	list-style:none;
}
li{
	width: 80px;
	height: 30px;
	line-height: 30px
}
a{
	text-decoration:none; 
	color:blue
}
fieldset{
	width:600px;
	margin:10px;
	border:3px solid blue;
	border-bottom: 0px;
	border-left: 0px;
	border-right: 0px;
}
legend{
	color: blue;
	font-size: 20px;
}
td{
	width: 50px;
	height: 120px;
	border-bottom: 1px dashed #ccc;
}
table{
	border: 1px solid blue;
	text-align: center;
}
.td1{
	width: 50px;
	height: 25px;
}
.td2{
	width: 50px;
	height: 25px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
.td3{
	width: 50px;
	height: 25px;
}
.td4{
	width: 200px;
	height: 25px;
}
.td5{
	width: 50px;
	height: 25px;
	cursor: pointer;
}
.div{
	margin:0 auto; 
	width:800px; 
	height:600px; 
	overflow: auto;
	text-align: center;
} 



</style>
</head>
<body>
<script type="text/javascript">
function goTo(va1,va2,va3){
	if(document.getElementById(va2).src.indexOf("u120") > 0){
		document.getElementById(va2).src="../images/fzjz/u124.png";
		window.open("<%=basePath%>/fzjz/answer.jsp?p="+va1+"&id="+va2+"&ylId="+va3, "_blank");
	}else{
		alert("题目已点击过...");
	}
	
};
</script>
<div class="div"> 
	<fieldset>
      <legend>演练信息</legend>
     	<table>
     		<tr>
     			<td class="td1"></td>
     			<td class="td2">信息</td>
     			<td class="td3"></td>
     			<td class="td4">时间</td>
     			<td class="td5">操作</td>
     		</tr>
			<%
			if(list!=null){
				for(MnylProblems m :list){
			%>
					<tr>
		     			<td class="td1"><img src="../images/fzjz/u128.png"></td>
		     			<td class="td2"><%=m.getTitle() %></td>
		     			<td class="td3"><img src="../images/fzjz/u122.png"></td>
		     			<td class="td4"><%=m.getOpenTime() %></td>
		     			<td class="td5"><a href="javascript:void(0);" onclick="goTo('<%=m.getProblem() %>','<%=m.getId()%>','<%=ylId%>')"><img src="../images/fzjz/u120.png" id="<%=m.getId() %>" ></a></td>
		     		</tr>
			<%
				}
			}else{
			%>
				<tr>
					<td colspan="5">没有数据，请先添加问题</td>
				</tr>
			<%
			}
			%>
		</table>
    </fieldset>
</div>
</body>
</html>