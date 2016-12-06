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
	 // ����׼���õ�dom����ʼ��echartsͼ��
   var dom=document.getElementById('icon');
   var myChart = echarts.init(dom);
   var option = {
		    title: {
		        text: "��ˮ��ȱ仯",
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
		        data:['��ˮ���','1Сʱ����']
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
		            name : '��ˮ���',
		            axisLabel : {
		                formatter: '{value} cm'
		            }
		        },
		        {
		            type : 'value',
		            name : '1Сʱ����',
		            axisLabel : {
		                formatter: '{value} mm'
		            }
		        }
		    ],
		    series : [
		        {
		            name:'��ˮ���',
		            type:'line',
		            data:resultArray,
		            markLine : {
		                data : [
		                    {type : 'average', name: 'ƽ��ֵ'}
		                ]
		            }
		        },
		        {
		            name:'1Сʱ����',
		            type:'line',
		            yAxisIndex: 1,
		            data:hour1rArray,
		            markLine : {
		                data : [
		                    {type : 'average', name: 'ƽ��ֵ'}
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