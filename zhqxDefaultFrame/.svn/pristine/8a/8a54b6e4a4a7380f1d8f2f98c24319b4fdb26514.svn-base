<%@page import="cn.com.oking.waterdata.pkyl_lookx"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.waterdata.GetPkfsSx"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<% 
String sid=request.getParameter("id");
String time=request.getParameter("time");
String name=request.getParameter("name");

String etype=request.getParameter("etype");

GetPkfsSx getPkfsSx=(GetPkfsSx) ContextHolder.getApplicationContext().getBean(GetPkfsSx.class);

  String  jsoncs2=pkyl_lookx.getData(time,1);
    String  jsoncs3=getPkfsSx.getJson2(sid);
	
	Date d = new Date();  
SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
String date = ss.format(d);  
String year=date.substring(0, 4);
String month=date.substring(5, 7);
String day=date.substring(8, 10);
String hour=date.substring(11,13);
int a=Integer.parseInt(day);
int b=a-1;
 SimpleDateFormat sdf  = new SimpleDateFormat("yyyy年MM月dd日 ");  
         Date d1 =new Date();
         long l = d1.getTime()-0*60*1000;//当前时间+10分钟
         long zz=d1.getTime()-1440*60*1000;
         String y=sdf.format((new Date(l)));
         String z1=sdf.format((new Date(zz)));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="../js/echarts-all.js"></script>
    
    <script type="text/javascript">
 		function load() {
            	 var dom=document.getElementById('main');
                 var myChart = echarts.init(dom);
                var option = {
                	 title : {
                	        text: '<%=name%>风速时序图',
                			x:'center'
                	    },
                    tooltip : {
                    	 formatter: "{b}<br/>{a}:{c}m/s<br/>",
                        trigger: 'axis'
                    },
                    grid :{
                		y2:80
                	},
                    legend: {
                        data:['']
                    },
                    toolbox: {
                        show : false,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
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
                            type : 'value',
                            name : '风速(m/s)',
                            splitArea : {show : true}
                        }
                    ],
                    series : [
                       
                        {
                            name:'整点风速',
                            type:'<%=etype%>',
                            itemStyle: {
                                normal: {
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

    <div id="main" style=" min-width:650px;height:400px;border:0px solid #ccc;padding:10px;"></div>

   
   
</body>
</html>
