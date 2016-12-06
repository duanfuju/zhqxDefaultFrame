/** @Bind #dsCondition.onReady */
!function(dsCondition){
	dsCondition.insert();
};


/** @Bind #btnSearch.onClick */
!function(afCondition,ifShow){
	var entity = view.get("#afCondition.entity");
	var stationName=entity.get("stationName");
	var time=entity.get("time");
	var part=entity.get("part");
	var type=entity.get("type");
	var num=entity.get("num");
	time=date(time);
	if (part=="雨量") {
		if (type=="折线图") {
			ifShow.set("path","echarts/echarts_sx_yl.jsp?etype=line&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else if (type=="柱状图") {
			ifShow.set("path","echarts/echarts_sx_yl.jsp?etype=bar&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else{
			alert("图表选择错误,请重新选择");
			return;
		}
	}else if (part=="温度") {
		if (type=="折线图") {
			ifShow.set("path","echarts/echarts_sx_wd.jsp?etype=line&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else if (type=="柱状图") {
			ifShow.set("path","echarts/echarts_sx_wd.jsp?etype=bar&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else{
			alert("图表选择错误,请重新选择");
			return;
		}
	}else if (part=="风速") {
		if (type=="折线图") {
			ifShow.set("path","echarts/echarts_sx_fs.jsp?etype=line&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else if (type=="柱状图") {
			ifShow.set("path","echarts/echarts_sx_fs.jsp?etype=bar&id="+num+"&time="+time+"&name="+stationName+time+part+"时序图");
		}else{
			alert("图表选择错误,请重新选择");
			return;
		}
	}else{
		alert("要素选择错误,请重新选择");
		return;
	}
	ifShow.reload();
};




function date(dates){
    var date = new Date(dates);
    var year = date.getFullYear();
    var month = date.getMonth()+1;    
    var date1 = date.getDate(); 
    var hour = date.getHours(); 
    var minutes = date.getMinutes();
    var seconds=date.getSeconds();
    return year+"-"+month+"-"+date1+" "+hour+":"+minutes;
}