<%@page import="cn.com.oking.waterMonitoring.action.GetYlPx"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%  
    String startTime=request.getParameter("startTime");
	String endTime=request.getParameter("endTime");
	GetYlPx yl=(GetYlPx) ContextHolder.getApplicationContext().getBean(GetYlPx.class);
 	String  jsoncs2=yl.getJson1(startTime, endTime);
    String  jsoncs3=yl.getJson2(startTime,endTime);
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
				
				 title : {
        text: '浦口<%=startTime%>至<%=endTime%>累积降雨排序图',
		x:'center'
    },
    tooltip : {
            formatter: "{b}<br/>{a}:{c}mm<br/>",
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
		 
		 	color:'black'
		 }
		
	},
            data : <%=jsoncs2%>
        }
    ],
    yAxis : [
        {
		
		splitArea: { show: true },
            type : 'value',
            name : '降水量(mm)',
            axisLabel : {
                formatter: '{value} '
            }
        }
        
    ],
	animation:false,
    series : [

        
        {
            name:'降雨量',
            type:'bar',
			itemStyle: {
                normal: {
				//label : {show: true, position: 'top'},
				//barBorderRadius:8,
                    color: '#468bfd',
                    lineStyle: {        // 系列级个性化折线样式
                        width: 2,
                        type: 'dashed'
                    }
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
<div id="main" style="height:370px;"></div>
</body>
</html>