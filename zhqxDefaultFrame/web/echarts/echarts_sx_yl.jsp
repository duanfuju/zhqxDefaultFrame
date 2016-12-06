<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.waterdata.pkyl_looky"%>
<%@page import="cn.com.oking.waterdata.pkyl_lookx"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<% 
session.setAttribute("yemian", "");
pkyl_looky pkyl_looky=(pkyl_looky) ContextHolder.getApplicationContext().getBean(pkyl_looky.class);

String etype=request.getParameter("etype");
String sid=request.getParameter("id");
String time=request.getParameter("time");
String name=request.getParameter("name");
  String  jsoncs2=pkyl_lookx.getData(time, 1);
  
    String  jsoncs3=pkyl_looky.getJson1hour2(sid,time);
	String maxnum=pkyl_looky.getMax1hour(sid, time);
	String []shu =maxnum.split("\\.");
	String zbc=shu[0];
	int max=Integer.parseInt(zbc);	
int fmax=2;
if(max>2){
fmax=max+2;
}else{
	fmax=2;
}	

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
            	        text: '<%=name%>',
            			x:'center'
            	    },
                tooltip : {
                	 formatter: "{b}<br/>{a}:{c}mm<br/>",
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
					max:<%=fmax%>,
                        type : 'value',
                        name : '降水量(mm)',
                        splitArea : {show : true}
                    }
                ],
                series : [
                   
                    {
                        name:'降水量',
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