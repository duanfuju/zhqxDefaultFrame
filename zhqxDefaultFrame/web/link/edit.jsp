<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="cn.com.oking.link.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>链接编辑</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<style>
.clearfloat{clear:both;height:0;font-size: 1px;line-height: 0px;} 
ul{
width:700px;
margin-left:0px;}
	li{
		float:left;
	list-style:none;
	padding:10px 10px;
	width:29%;
	height:40%;
	text-align:center;
	
	}
	a{
	text-decoration:none;
	
	}
	a:hover{
	color:#3300FF}
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
<script>
		function h1(){
			
			document.getElementById("tj").src="images/ctj.png";
		};
		function h2(){
			
			document.getElementById("tj").src="images/tj.png";
		};
		function b1(){
			document.getElementById("bj").src="images/cbj.png";
		};
		function b2(i){
			
			document.getElementById("bj").src="images/bj.png";
		};
		function s(){
			document.getElementById("del").style.display='';
		};
		function d1(i){
			var ii="del"+i;
			document.getElementById(ii).src="images/cdel.png";
		};
		function d2( i){
			var ii="del"+i;
			document.getElementById(ii).src="images/delete.png";
		};
		function del(linkid){
			 var parameter={linkid:linkid};
			 <%
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			%>
			$.ajax({
		    	type: "POST",
				dataType:"HTML",
				url:"<%=basePath%>/linkDelServlet",
				data:parameter,
				success:function(){
					//alert("删除成功！！！");
					$("#"+linkid).remove();
				},
				error:function(){
					alert("删除失败！！！");
				}
			});
		}
		
</script>
 
<body>
<div style="width:750px; height:100%">


        
  <%
  String mid=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
  getModule d=(getModule) ContextHolder.getApplicationContext()
	.getBean(getModule.class);
  
  List<Map<String, Object>> list=d.getListById(mid);
  for (Map<String, Object> map : list) {
	  String modulename=map.get("modulename").toString();
	  String id=map.get("id").toString();
	  
	  getHrefItem g=(getHrefItem) ContextHolder.getApplicationContext()
				.getBean(getHrefItem.class);
	  List<Map<String, Object>> linklist=g.getList(id);
  
  %>      
<!--模块1-->
<div style="float:left; margin-bottom:10px;">
<div >
<span style="font-weight:bold"> <%=modulename %></span>
 
 </div>
<div style="width:700px; height:60px;min-height:60px; height:auto!important; border:1px solid #d0d0d0">
	<input type="hidden" id="orderlist" /> 
	<ul id="sortable">
		<%
			for(int j=0;j<linklist.size();j++){
				Map<String,Object> vs1=linklist.get(j);
				String linkid=vs1.get("id").toString();
				Object itemname=vs1.get("itemname");
				Object itemurl=vs1.get("itemurl");
				Object opentype=vs1.get("opentype");
				String ordernum=vs1.get("ordernum").toString();
		%>
		<li id="<%=linkid%>" title="<%=linkid %>" value="<%=ordernum %>" ><a><img onmousemove="d1(<%=j %>)" onmouseout="d2(<%=j %>)" onclick="del(<%=linkid%>)"  id="del<%=j %>" src="images/delete.png" width="10" height="10"/></a>&nbsp;<a href="<%=itemurl%>" target="<%=opentype%>"><%=itemname %></a></li>
		<%} %>
		<div class="clearfloat"></div>
	</ul>
</div>
</div>
<%} %>
</div>
<script>
		  $(function() {
			  //定义隐藏域（用来存储初始化时的ordernum）
			  var $orderlist = $("#orderlist"); 
			  //定义ul
			  var $list = $("#sortable"); 
			  //定义存储ordernum的数组
			  var old_order = []; 
			  //迭代标签的模块，取出初始化时的ordernum
			  $list.children("li").each(function() { 
				  old_order.push(this.value); 
	              }); 
			  //将数组转化成字符串
			  var oldid = old_order.join(','); 
			  //为隐藏域赋值
             $orderlist.val(oldid); 
             
             
		    $list.sortable({
		    	 opacity: 0.6, //设置拖动时候的透明度 
		         revert: true, //缓冲效果 
		         cursor: 'move', //拖动的时候鼠标样式 
		         update:function(){
		        	  var new_order = []; 
		              $list.children("li").each(function() { 
		                 new_order.push(this.title); 
		              }); 
		              var newid = new_order.join(','); 
		              var oldid = $orderlist.val(); 
		              var parameter={ id: newid, order: oldid};
		        	 $.ajax({
		 		    	type: "POST",
		 				dataType:"HTML",
		 				url:"<%=basePath%>/sortableServlet",
		 				data:parameter,
		 				success:function(){
		 					//alert("修改成功！！！");
		 				},
		 				error:function(){
		 					alert("修改失败！！！");
		 				}
		 			});
		         }
		    });
		    
		  //设置ul不能选择。  
		    $( "#sortable" ).disableSelection();
		  });

</script>
</body>
</html>



