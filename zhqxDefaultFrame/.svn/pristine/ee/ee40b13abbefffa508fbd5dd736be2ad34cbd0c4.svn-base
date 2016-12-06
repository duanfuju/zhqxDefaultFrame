var siteid="${request.getParameter('siteid')}";


/** @Bind #dsWaterDatashow.onReady */
!function(dsWaterDatashow){
	var parameter={
			siteid:siteid
	};
	dsWaterDatashow.set('parameter',parameter);
	dsWaterDatashow.flushAsync();
};







/** @Bind #txtStart.onReady  */
!function(txtStart,txtEnd){
	var mydate=new Date();
	var mymonth=mydate.getMonth()+1;        
	var day= mydate.getDate(); 
	var myyear= mydate.getYear();
	var year=(myyear > 200) ? myyear : 1900 + myyear;
	txtEnd.set("text",year+"-"+mymonth+"-"+day);
	txtStart.set("text",year+"-"+mymonth+"-"+(day-1));
	
};

/** @Bind #btnLikeSearch.onClick  */
!function(txtStart,txtEnd,dsWaterDatashow){
	var sdate= txtStart.get("text");
	var edate= txtEnd.get("text");
	if (!sdate) {
		return;
	}
	if (!edate) {
		return;
	}
	var parameter={
			sdate:sdate,
			edate:edate,
			siteid:siteid
	};
	dsWaterDatashow.set('parameter',parameter);
	dsWaterDatashow.flushAsync();
};


/** @Bind #dsWaterData.onReady */
!function(dsWaterData,ifWaterShow){
	if (siteid) {
		dsWaterData.set('parameter',siteid);
		dsWaterData.flushAsync();
	}
	ifWaterShow.set("path","waterTable.jsp?siteid="+siteid);
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



/** @Bind #dataSetDropDown1.onClose */
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
	var cur="";
	dsWaterData.getData().each(function(entity){
		if (entity.get("wdId")=="current") {
			cur=entity.get("wdResults");
		}
	});
	createIcon(cur);
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


