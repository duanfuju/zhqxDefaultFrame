<%@page import="cn.com.oking.em.entity.EmMonitoring"%>
<%@page import="cn.com.oking.util.StringUtil"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.dorado.core.Configure"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Hello,world</title>
<link rel="stylesheet" type="text/css" href="../../css/gaodeMap.css" />
<script type="text/javascript" src="../../js/gaodeMap.js"></script>

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
var mapObj;
function initialize(){
  var position=new AMap.LngLat(118.627894,32.059091);
  mapObj=new AMap.Map("container",{
  view: new AMap.View2D({//创建地图二维视口
	  center:position,//创建中心点坐标
	  zoom:16, //设置地图缩放级别
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
  var markers = []; 
  
<%
  	List<EmMonitoring> data=(List<EmMonitoring>)session.getAttribute("maps");
 	for (int i = 0; i < data.size(); i ++) {  
 		EmMonitoring em=data.get(i);
  		if(i==0&&data.size()==1){
	%> //设置中心坐标以及缩放程度
	mapObj.setZoomAndCenter(16, new AMap.LngLat(<%=em.getLongitude()%>,<%=em.getLatitude()%>));
		<%}%>
      var markerPosition = new AMap.LngLat(<%=em.getLongitude()%>,<%=em.getLatitude()%>);  
      var marker = new AMap.Marker({  
          map:mapObj,  
          position:markerPosition, //基点位置  
         icon: new AMap.Icon({
				size:new AMap.Size(35, 35)
			}), //marker图标，直接传递地址url  
          offset:new AMap.Pixel(-10, -35)	 //相对于基点的位置  
      });  
      var images="<%=em.getPath()%>";
      AMap.event.addListener(marker, 'click', function (entity) {  
    	  var infoWindow = new AMap.InfoWindow({  
          	isCustom:true,
              content:createInfoWindow("详细信息","<img width='200px' height='100px' src='../../"+images+"'/><br/>地  点：<%=em.getLocation()%><br/>编  号：<%=em.getEquipmentnum()%> <br/>状  态：<%=em.getStatus()%> <br/>归  属：<%=em.getDept()%>"),  
              size:new AMap.Size(300, 0),  
              autoMove:true,   
              offset:new AMap.Pixel(10,-30)  
          });	  
          infoWindow.open(mapObj, new AMap.LngLat(entity.lnglat.lng,entity.lnglat.lat));  
          mapObj.setZoomAndCenter(16, new AMap.LngLat(entity.lnglat.lng,entity.lnglat.lat));
      });  
      markers.push(marker);  
<%
     }
%> 
 
}
//关闭信息窗体  
function closeInfoWindow(){  
    mapObj.clearInfoWindow();  
}

</script>
</head>
 
<body onload="initialize()">
<div id="container"></div>
</body>
</html>