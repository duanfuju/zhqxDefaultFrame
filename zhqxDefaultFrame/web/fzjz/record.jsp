<%@page import="cn.com.oking.fzjz.action.MnylResultrecordAction"%>
<%@page import="cn.com.oking.fzjz.entity.MnylResultrecord"%>
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
<title>演练结果</title>
 <script type="text/javascript" src="../js/jquery-1.8.0.js"></script>
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
	width:750px;
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
	width: 350px;
	height: 50px;
	border-bottom: 1px dashed #ccc;
	font-size: 12px;
}
table{
	border: 1px solid blue;
	text-align: center;
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
<%
	
	String ylId=new String(request.getParameter("ylId").getBytes("ISO-8859-1"),"UTF-8");
	MnylProblemsAction action=(MnylProblemsAction) ContextHolder.getApplicationContext().getBean(MnylProblemsAction.class);
	MnylResultrecordAction r_action=(MnylResultrecordAction) ContextHolder.getApplicationContext().getBean(MnylResultrecordAction.class);
	List<MnylProblems> list=action.findByYlId(ylId);
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
$(document).ready(function(){
	  //根据checkbox的值显示是否选中的状态
		$(".cb").each(function(){
			var val=$(this).attr("value");
			if(val=="true"){
				$(this).attr("checked",'ture');
			}
		});
});
</script>





<div class="div"> 
	<fieldset>
      <legend>演练结果</legend>
     	<table>
     		<tr>
     			<td class="td1">问题标题</td>
     			<td class="td2">问题内容</td>
     			
     		</tr>
			<%
			if(list.size()>0){
				for(MnylProblems m :list){
			%>
					<tr>
		     			<td class="td1"><%=m.getTitle() %></td>
		     			<td class="td2"><%=m.getProblem() %></td>
		     			<td>
		     				<table>
		     					<tr>
					     			<td class="td3">问题的回答</td>
					     			<td class="td5">问题的答案</td>
					     		</tr>
				     			<%
				     				List<MnylResultrecord> mlist=r_action.findByAnswerId(m.getId());
				     				for(MnylResultrecord r :mlist){
				     			%>
				     			<tr>
					     			<td class="td3"><input type="checkbox" class="cb" disabled="disabled"  value="<%=r.getOptionChoose() %>" /><%=r.getOptionText() %></td>
					     			<td class="td5"><input type="checkbox" class="cb" disabled="disabled"  value="<%=r.getOptionIstrue() %>" /><%=r.getOptionText() %></td>
					     		</tr>
				     			<%
				     			}
				     			%>
				     			</table>
				     		
		     			</td>
		     		</tr>
			<%
				}
			}else{
			%>
				<tr>
					<td colspan="5">没有数据</td>
				</tr>
			<%
			}
			%>
		</table>
    </fieldset>
</div>
</body>
</html>