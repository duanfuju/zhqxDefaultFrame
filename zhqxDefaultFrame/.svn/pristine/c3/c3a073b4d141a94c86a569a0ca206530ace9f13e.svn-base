var siteid="${request.getParameter('siteid')}";

/** @Bind #dsWaterData.onReady */
!function(dsWaterData){
	if (siteid) {
		dsWaterData.set('parameter',siteid);
		dsWaterData.flushAsync();
	}
};

/** @Bind #dsWaterData.onLoadData */
!function(hcLineChart,dsWaterData,dsRain){
	var dateArray=[];
	var resultArray=[];
	dsWaterData.getData().each(function(entity){
		dateArray.push(date(entity.get("wdDate")));
		resultArray.push(entity.get("wdResults"));
	});
	var dateTimeArray=[];
	var hour1rArray=[];
	dsRain.getData().each(function(entity){
		dateTimeArray.push(date(entity.get("ddatetime")));
		hour1rArray.push(entity.get("hour1r"));
	});	
	createIcon(dateArray,resultArray,dateTimeArray,hour1rArray);
};

function createIcon(dateArray,resultArray,dateTimeArray,hour1rArray){
	 // 基于准备好的dom，初始化echarts图表
   var dom=document.getElementById('icon');
   var myChart = echarts.init(dom);
   var option = {
		    title: {
		        text: "积水深度变化",
		        x: "center"
		    },
		    tooltip : {
		        trigger: 'axis',
		    },
		    toolbox: {
		        show : true,
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
		    	 x: 'left',
		        data:['积水深度','1小时雨量']
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dateArray
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value',
		            name : '积水深度',
		            axisLabel : {
		                formatter: '{value} cm'
		            }
		        },
		        {
		            type : 'value',
		            name : '1小时雨量',
		            axisLabel : {
		                formatter: '{value} mm'
		            }
		        }
		    ],
		    series : [
		        {
		            name:'积水深度',
		            type:'line',
		            data:resultArray,
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        },
		        {
		            name:'1小时雨量',
		            type:'line',
		            yAxisIndex: 1,
		            data:hour1rArray,
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
		};
   myChart.setOption(option);
}


function date(dates){
    var date = new Date(dates);
    var year = date.getFullYear();
    var month = date.getMonth()+1;    
    var date1 = date.getDate(); 
    var hour = date.getHours(); 
    var minutes = date.getMinutes(); 
    return year+"-"+month+"-"+date1+" "+hour+":"+minutes ;
};