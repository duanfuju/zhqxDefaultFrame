<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.waterMonitoring.action.GetWdPx"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<% 
    String startTime=request.getParameter("startTime");
	String endTime=request.getParameter("endTime");
    GetWdPx wd=(GetWdPx) ContextHolder.getApplicationContext().getBean(GetWdPx.class);
 	String  jsoncs2=wd.getJsonzd(startTime,endTime);
    String  jsoncs3=wd.getJson3(startTime,endTime);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ECharts</title>
<script src="../js/echarts-all.js"></script>
<script type="text/javascript">
function load() {
     var dom=document.getElementById('main');
     var myChart = echarts.init(dom);
	 var option = {
//	backgroundColor:'#EFF7FF', 
	 title : {
        text: '浦口<%=startTime%>至<%=endTime%>最低气温排序图',
		x:'center'
    },
    tooltip : {
	 formatter: "{b}<br/>{a}:{c}℃<br/>",
        trigger: 'axis'
		
    },
		grid :{
		y2:100
	},
    toolbox: {
        show : false,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    legend: {
        data:[''],
		show:false
    },
	
	
    xAxis : [
		
        {
            type : 'category',
			axisLabel: {
		rotate:0,
		interval:0,
		//margin:0,
		textStyle:{
		 
		 }
		
	},
            data : <%=jsoncs2%>
        }
    ],
    yAxis : [
        {
		splitArea: { show: true },
            type : 'value',
			 name : '温度(℃)',
            axisLabel : {
                formatter: '{value} '
            }
        }
        
    ],
    series : [

        
        {
            name:'最低气温',
            type:'bar',
			itemStyle: {
                normal: {
				//barBorderRadius:8,
                  //深蓝色  color: '#468bfd',  
				    color: '#468bfd',
                    lineStyle: {        // 系列级个性化折线样式
                        width: 2,
                        type: 'dashed'
                    }
                },
				 emphasis: {
				 label:{
				 	show:false
				 },
                    color: '#468bfd'
                }
               
            },
			barWidth:15,
            data:<%=jsoncs3%>
        }
        
    ]
};
    myChart.setOption(option); 
};
</script>
</head>
<body onload="load()">
<div id="main" style="height: 400px; margin: 0 auto "></div>
</body>
</html>
