<%@page import="com.bstek.dorado.core.Configure"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>地图覆盖物</title>
<script language="javascript" src="http://webapi.amap.com/maps?v=1.2&key=23e8cfe2d8f3ce1e4a4197902d28f445"></script>
<script language="javascript" src="../js/jquery-1.8.0.js"></script>
</head>
<body onLoad="mapInit()">
    <div id="iCenter" style="float:left;width:780px;height:320px;"></div>
    <div style="float:left;width:700px;height: 20px;">
   		现在的坐标：<span id="lnglat"></span>
        <button onclick="javascript:clearMap();">清空地图</button>
       </div>
</body>
<script language="javascript">
var mapObj;
var marker;  
var cloudDataLayer;
var longitude;
var latitude;
//初始化地图对象，加载地图  
function mapInit(){  
    mapObj = new AMap.Map("iCenter",{  
    center:new AMap.LngLat(118.627894,32.059091), //地图中心点  
    level:16  //地图显示的比例尺级别  
    }); 
    AMap.event.addListener(mapObj,'click',getLnglat); //点击事件 
}  
//鼠标点击，获取经纬度坐标  
function getLnglat(e){    
     x = e.lnglat.getLng();
     y = e.lnglat.getLat(); 
    document.getElementById("lnglat").innerHTML ="经度："+ x + "		，		纬度：" + y;
    var marker = new AMap.Marker({	
		//复杂图标
		icon: new AMap.Icon({    
				//图标大小
				size:new AMap.Size(28,37)
			}),
		//在地图上添加点
		position:new AMap.LngLat(x,y),
		offset: new AMap.Pixel(-18,-36), //相对于基点的偏移位置
	});
    
	marker.setMap(mapObj);  
	getCoordinates();
}
//清空地图
function clearMap(){	
	mapObj.clearMap();
	cloudDataLayer.setMap(null);
}
function getCoordinates(){
	var parameter={
			longitude:x,
			latitude:y
	};
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	$.ajax({
	    	type: "POST",
			dataType:"HTML",
			url:'<%=basePath%>/MapCoordinatesServlet',
			data:parameter,
			error:function(){
				alert("失败,请刷新");
			}
		});
}	
</script>
</html>