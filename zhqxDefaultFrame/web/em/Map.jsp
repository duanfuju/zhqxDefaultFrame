<%@page import="com.bstek.dorado.core.Configure"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Hello,world</title>
<style type="text/css">
html{height:100%}
body{height:100%;margin:0px;padding:0px}
#container{height:100%}
span{
			display: block;
			height:200px;
			width:180px;
			text-align:center;
			padding-left:10px;
			padding-right:10px;
			line-height:40px;
			background-color:#fff;
			border:1px solid #ccc;
			color:#FF6BBB;
			font-size:12px;
			border-radius:3px;
		}
</style>
<script type="text/javascript"
src="http://webapi.amap.com/maps?v=1.3&key=e1032ecb106aa9c7df27bebcfa3ed92f">
</script>
<script type="text/javascript">
function initialize(){
  var position=new AMap.LngLat(118.627894,32.059091);
  var mapObj=new AMap.Map("container",{
  view: new AMap.View2D({//创建地图二维视口
	  center:position,//创建中心点坐标
	  zoom:14, //设置地图缩放级别
	  rotation:0 //设置地图旋转角度
	 }),
	 lang:"zh_cn"//设置地图语言类型，默认：中文简体
	});//创建地图实例
  mapObj.plugin(["AMap.ToolBar"],function(){   //在地图中添加ToolBar插件      
      toolBar = new AMap.ToolBar();  
      mapObj.addControl(toolBar);       
  });  
  mapObj.plugin(["AMap.MouseTool"],function(){        //鼠标工具插件
      mousetool = new AMap.MouseTool(mapObj);             
  });
}
</script>
</head>
 
<body onload="initialize()">
<div id="container"></div>
</body>
</html>