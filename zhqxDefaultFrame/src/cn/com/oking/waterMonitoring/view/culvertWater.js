var siteid="T01";




/** @Bind #dsWaterWithSS.onReady */
!function(dsWaterWithSS){
	dsWaterWithSS.set('parameter',siteid);
	dsWaterWithSS.flush();
	
};



/** @Bind #hcDashboard.onReady */
!function(dsWaterWithSS){
	var num=0;
	dsWaterWithSS.getData().each(function(entity){
		if (num==0) {
			createIcon(entity.get("rz"));
		}
		num++;
	});
};




/** @Bind #ifShowPic.onReady */
!function(dsPicWithSS,ifShowPic){
	var num=0;
	dsPicWithSS.getData().each(function(entity){
		if (num==0) {
			var DT=entity.get("DT");
			DT=DT.replace(" ","%20");
			var Scanid=entity.get("Scanid");
			var STCD=entity.get("STCD");
			ifShowPic.set("path","showPic.jsp?DT="+DT+"&Scanid="+Scanid+"&STCD="+STCD);
		}
		num++;
	});
	
};


/** @Bind #dgPicWithSS.onDataRowClick   */
!function(ifShowPic){
	var datagrid = this.get("#dgPicWithSS");
	var dataset =datagrid.get("dataSet");
	var row = dataset.getData("#");
	var DT=row.get("DT");
	DT=DT.replace(" ","%20");
	var Scanid=row.get("Scanid");
	var STCD=row.get("STCD");
	ifShowPic.set("path","showPic.jsp?DT="+DT+"&Scanid="+Scanid+"&STCD="+STCD);
};





/** @Bind #dgWaterWithSS.onDataRowClick   */
!function(){
	var datagrid = this.get("#dgWaterWithSS");
	var dataset =datagrid.get("dataSet");
	var row = dataset.getData("#");
	var rz= row.get("rz");
	createIcon(rz);
};







/** @Bind #dgSelectStation.onDataRowClick   */
!function(dgSelectStation){
	var datagrid = this.get("#dgSelectStation");
	var dataset =datagrid.get("dataSet");
	var row = dataset.getData("#");
	var stationNum= row.get("stationNum");
	location.href="cn.com.oking.waterMonitoring.view.realTimeMonitor.d?siteid="+stationNum;

};








/** @Bind #hcShow.onReady */
!function(dsWaterPicture,hcShow,afeSelect){
	var entity = dsWaterPicture.getData().current;
	hcShow.set("content","<center style='width:100%;height:100%;text-align:center;'><a href='http://218.2.99.66/pkqx/dorado/movie2/hkws.html'target='_Blank'>" +
			"<div style='background-image:url("
			+entity.get("filedir")+"/"+entity.get("filename")+");background-repeat: no-repeat;background-size:contain;" +
					"width:48%;height:90%;margin:0 auto;'></div></a></center>");
	
	afeSelect.set("value",date(entity.get("filetime")));

};






function date(dates){
    var date = new Date(dates);
    var year = date.getFullYear();
    var month = date.getMonth()+1;    
    var date1 = date.getDate(); 
    var hour = date.getHours(); 
    var minutes = date.getMinutes();
    var seconds=date.getSeconds();
    return year+"-"+month+"-"+date1+" "+hour+":"+minutes +":"+seconds ;
}


/** @Bind #dsWaterData.onLoadData */
!function(dsWaterData){
	/*var cur="";
	dsWaterData.getData().each(function(entity){
		if (entity.get("wdId")=="current") {
			cur=entity.get("wdResults");
		}
	});
	createIcon(cur);*/
};

function createIcon(cur){
	 // 基于准备好的dom，初始化echarts图表
	var dom=document.getElementById('icon');
    var myChart = echarts.init(dom);
    var option = {
    	    tooltip : {
    	        formatter: "{a} <br/>{b} : {c}CM"
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    series : [
    	        {
    	        	max:100,
    	        	splitNumber:5,
    	            name:'降水量',
    	            type:'gauge',
    	            detail : {formatter:'{value}CM \n 当前积水深度 ',
		    	                textStyle: {
		    	                      color: 'auto',
		    	                      fontSize : 20
		    	                }},
    	            data:[{value: cur, name: '警戒值'}],
    	            axisLine: {            // 坐标轴线
    	                show: true,        // 默认显示，属性show控制显示与否
    	                lineStyle: {       // 属性lineStyle控制线条样式
    	                    color: [[0.25, 'lightgreen'],[0.4, 'orange'],[1, 'red']], 
    	                    width: 30
    	                }
    	            },
    	            radius:['30%','100%']
    	        }
    	    ]
    	};
    myChart.setOption(option);
}


