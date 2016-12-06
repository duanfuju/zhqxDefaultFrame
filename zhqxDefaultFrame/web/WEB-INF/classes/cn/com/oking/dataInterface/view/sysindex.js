/** @Bind #dsSysList.onReady */
!function(dsSysList,hcShow){
	var htmlTre="";
	var htmlTrs="";
	dsSysList.getData().each(function(entity){
		var trColor="cgreen";
		if (entity.get("status")=="无效") {
			trColor="cred";
		}
		if (trColor=="cred") {
			htmlTre+="<tr>"
				+"<td rowspan='1'>"+entity.get("dataname")+"</td>"
				+"<td><span class='"+trColor+"' >"+entity.get("status")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("lastdate")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("overtime")+"</span></td>"
				+"<td ><span>30分钟</span></td>"
				+"<td><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"<td ><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"</tr> ";
		}
		if (trColor=="cgreen") {
			htmlTrs+="<tr>"
				+"<td rowspan='1'>"+entity.get("dataname")+"</td>"
				+"<td><span class='"+trColor+"' >"+entity.get("status")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("lastdate")+"</span></td>"
				+"<td ><span class='"+trColor+"' >"+entity.get("overtime")+"</span></td>"
				+"<td ><span>30分钟</span></td>"
				+"<td><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"<td ><span id='terminal_xq' style='cursor:pointer;' onclick='openTerminalList()'>----</span></td>"
				+"</tr> ";
		}
	});
	hcShow.set("content","<body> "
						  +" <div id='info_main'> "
						  +" <p  id='info_head'>系统运行异常状况汇总表</p> "
						  +" <p id='info_time'>(汇总时间：2015年5月22日16:46分)</p> "
						  +" <hr  id='info_span' color='#FF0000' size='5' /> "
						  +" <p style='color:red;font-size:14px;font-weight:bold;margin:0px;'>系统运行监控:</p> "
						  +" <table id='info_control' style='background-color:#cccccc; font-size:14px;font-weight: blod;'> "
						  +"	<tr id='info_control_title' style='background-color:blue;font-size:18px;'> "
						  +"		<td style='background-color:#99CCFF;font-weight: blod;'>系统名称</td> "
						  +"		<td style='background-color:#99CCFF;'>系统运行状态</td> "
						  +"		<td style='background-color:#99CCFF;'>异常出现时间</td> "
						  +"        <td style='background-color:#99CCFF;'>异常持续时间</td> "
						  +"		<td style='background-color:#99CCFF;'>超时报警阈值</td> "
						  +"		<td style='background-color:#99CCFF;'>详情</td> "
						  +"        <td style='background-color:#99CCFF;'>故障记录</td> "
						  +"	</tr> "
						  +htmlTre+htmlTrs
						  +" </table> "
						  +" </div> "
						  +" </body>");
};