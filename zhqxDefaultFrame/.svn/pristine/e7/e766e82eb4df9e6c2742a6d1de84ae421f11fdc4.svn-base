
/** @Bind #hcShow.onReady */
!function(dsMonitor,hcShow){
	var htmlTre="";
	var htmlTrs="";
	dsMonitor.getData().each(function(entity){
		var trColor="cgreen";
		if (entity.get("datastatus")=="异常") {
			trColor="cred";
		} 
		if (trColor=="cred") {
			htmlTre+="<tr>"
				+"<td rowspan='1'>"+entity.get("dataname")+"</td>"
				+"<td><span class='"+trColor+"' >"+entity.get("datastatus")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("lastdate")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("delaytime")+"</span></td>"
				+"<td ><span>"+entity.get("overtime")+"</span></td>"											
				+"<td><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'><a href='http://218.2.99.66/pkqx/znjk/pdfRead.jsp?swf="+entity.get("detaillist")+"'>----</a></span></td>"
				+"<td ><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"</tr> ";
		}
		if (trColor=="cgreen") {
			htmlTrs+="<tr>"
				+"<td rowspan='1'>"+entity.get("dataname")+"</td>"
				+"<td><span class='"+trColor+"' >"+entity.get("datastatus")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("lastdate")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("delaytime")+"</span></td>"
				+"<td ><span>"+entity.get("overtime")+"</span></td>"
				+"<td><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'><a href='http://218.2.99.66/pkqx/znjk/pdfRead.jsp?swf="+entity.get("detaillist")+"'>----</a></span></td>"
				+"<td ><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"</tr> ";
		}
		
	});
	hcShow.set("content","<div id='info_main'>"
		+"<p  id='info_head'>数据接口异常状况汇总表</p>"
		+"<!--div  id='info_com'>"
		+"	<table >"
		+"			<tr><td id='info_dept'>浦口气象台</td><td id='info_by'>发布人：管理员</td></tr>"
		+"	</table>"
		+"</div-->"
		+"<hr  id='info_span' color='#FF0000' size='5' />"
		+"<p style='color:red;font-size:14px;font-weight:bold;margin:0px;'>数据接口监控:</p>"
		+"<table id='info_control' style='background-color:#cccccc; font-size:14px;font-weight: blod;'>"
		+"	<tr id='info_control_title' style='background-color:blue;font-size:18px;'> "
		+"		<td style='background-color:#99CCFF;font-weight: blod;'>接口名称</td>"
		+"		<td style='background-color:#99CCFF;'>接口状态</td>"
		+"		<td style='background-color:#99CCFF;'>最近入库时间</td>"
		+"    <td style='background-color:#99CCFF;'>超时入库时间</td>"
		+"		<td style='background-color:#99CCFF;'>超时报警阈值</td>"
		+"		<td style='background-color:#99CCFF;'>接口说明</td>"
		+"   <td style='background-color:#99CCFF;'>故障记录</td>"
		+"	</tr> "+htmlTre+htmlTrs
		+"</table>"
		+"</div>"
	);
};


 
 

