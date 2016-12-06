<%@page import="cn.com.oking.fzjz.entity.MnylResultrecord"%>
<%@page import="cn.com.oking.fzjz.action.MnylResultrecordAction"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回答问题界面</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					
	String p=request.getParameter("p");
	String id=request.getParameter("id");
	String ylId=request.getParameter("ylId");
	
	MnylResultrecordAction action=(MnylResultrecordAction) ContextHolder.getApplicationContext().getBean(MnylResultrecordAction.class);
	List<MnylResultrecord> list=action.findByAnswerId(id);
%>
<script language="javascript" src="../js/jquery-1.8.0.js"></script>  
<script language="javascript">
function custom_close(){
	if (confirm("您确定要关闭本页吗？")){
		window.opener=null;
		window.open('','_self');
		window.close();
	}
}


function submitFrom(){
	var checkboxs="";
	var ids="";
	var ylId="<%=ylId%>";
	var checkbox=document.getElementsByName("cb");
    for(var i=0;i<checkbox.length;i++){
        var c=checkbox[i];
        checkboxs+=c.checked+",";
    	ids+=c.value+",";
    }
    
	if (!checkboxs||!ylId||!ids) {
		alert("数据采集出错，请联系管理员");
		return;
	}
	var parameter={checkboxs:checkboxs,ylId:ylId,ids:ids};
	$.ajax({
    	type: "POST",
		dataType:"HTML",
		url:"<%=basePath%>ResultRecordServlet",
		data:parameter,
		success:function(){
			alert("提交成功！！！");
			window.opener=null;
			window.open('','_self');
			window.close();
		},
		error:function(){
			alert("提交失败！！！");
		}
	});
}
	
</script>  
</head>
<body>
	<div style="margin:0 auto; width:800px; height:550px;overflow: auto;text-align: center;font-size: 20px;">
		<div style="width:780px; height:200px;">
			<span style="color:blue;float: left;">当前事件</span> 
			<div style="width:780px; height:150px;border:1px solid blue;float: left;line-height: 150px;font-size: 12px;">
				<%=p %>
			</div>     
		</div>
		<div style="width:780px; height:300px;">
			<span style="color:blue;float: left;">选择操作</span>
			<div style="width:780px; height:250px;border:1px solid blue;float: left;">
				<%
			if(list.size()>0){
				for(MnylResultrecord m :list){
			%>
					<div style="float:left;margin-left:10px;text-align:left;margin-top:20px;width: 45%; height: 50px;font-size: 12px;">
						<input type="checkbox" name="cb"  value="<%=m.getId() %>"  style="vertical-align:middle" />
						<%=m.getOptionText() %>
					</div>
			<%
				}
			}else{ 
			%>
				<div style="color:red;font-size: 25px;">没有选项数据，请先添加属于本问题的选项数据！！！</div>  
			<%
			}
			%>
			</div>
		</div>
		<button onclick="submitFrom()">确认</button>&nbsp;&nbsp; 
		<button onclick="custom_close()">取消</button>
	</div>
</body>
</html>