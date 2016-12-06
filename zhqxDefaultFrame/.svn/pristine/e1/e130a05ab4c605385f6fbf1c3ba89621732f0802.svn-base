/** @Bind #dsCondition.onReady */
!function(dsCondition){
	dsCondition.insert();
};


/** @Bind #btnSearch.onClick */
!function(afCondition,ifShow){
	var entity = view.get("#afCondition.entity");
	var startTime=entity.get("startTime");
	var endTime=entity.get("endTime");
	var type=entity.get("type");
	if (!startTime) {
		alert("开始时间不能为空");
		return;
	}
	if (!endTime) {
		alert("结束时间不能为空");
		return;
	}
	if (!type) {
		alert("要素不能为空");
		return;
	}
	if (startTime>endTime) {
		alert("开始时间不能大于结束时间");
		return;
	}
	startTime=date(startTime);
	endTime=date(endTime);
	if (type=="最高温") {
		ifShow.set("path","echarts/echarts_px_gw.jsp?startTime="+startTime+"&endTime="+endTime);
	}else if (type=="最低温") {
		ifShow.set("path","echarts/echarts_px_dw.jsp?startTime="+startTime+"&endTime="+endTime);
	}else if (type=="雨量") {
		ifShow.set("path","echarts/echarts_px_yl.jsp?startTime="+startTime+"&endTime="+endTime);
	}else if (type=="极大风速") {
		ifShow.set("path","echarts/echarts_px_fs.jsp?startTime="+startTime+"&endTime="+endTime);
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