	
	/*
	 * 获取url指定的参数 
	 * @param name-指定的参数
	 */
	function  getQueryString (name) {
	     // 如果链接没有参数，或者链接中不存在我们要获取的参数，直接返回空
	     if (location.href.indexOf("?") == -1 || location.href.indexOf(name + '=') == -1) {
	         return '';
	     }
	
	     // 获取链接中参数部分
	     var queryString = location.href.substring(location.href.indexOf("?") + 1);
	     queryString = decodeURI(queryString);
	
	     // 分离参数对 ?key=value&key2=value2
	     var parameters = queryString.split("&");
	
	     var pos, paraName, paraValue;
	     for (var i = 0; i < parameters.length; i++) {
	         // 获取等号位置
	         pos = parameters[i].indexOf('=');
	         if (pos == -1) { continue; }
	
	         // 获取name 和 value
	         paraName = parameters[i].substring(0, pos);
	         paraValue = parameters[i].substring(pos + 1);
	
	         // 如果查询的name等于当前name，就返回当前值，同时，将链接中的+号还原成空格
	         if (paraName == name) {
	             return unescape(paraValue.replace(/\+/g, " "));
	         }
	     }
	     return '';
	 }

	var _id = getQueryString("id");
	$(function(){
		
		$.post("../control.terminalState.d",{"ID":_id},
				function(rv){
					if(rv!=null && rv!=""){
						var bean = eval("["+rv+"]");
						
						$("#info_head").html("【"+bean[0].push_title+"】发布状况汇总表");
						$("#info_time").html("(发布时间："+bean[0].push_time+")");
						$("#info_content").html(bean[0].push_content);
						loadTerminal(bean[0].MEDIA);
						loadCmcc(bean[0].SMS_PU);
						loadLed(bean[0].SCREEN);
						loadWeibo(bean[0].BLOG,"weibo");
						loadWeibo(bean[0].WEICHAT,"weixin");
						loadWeibo(bean[0].PORTALS,"mh");
						loadWeibo(bean[0].COMMUNITY,"sq");
						loadWeibo(bean[0].STREET,"jd");
						loadWeibo(bean[0].DEPARTMENT,"bm");
						loadWeibo(bean[0].GOVOA,"oa");
						loadWeibo(bean[0].LEADERPLAT,"ld");
					}
				}
		);
		
	});
	
	loadTerminal  = function(type){
		type="%";
		if(type==null || type== ""){
			  $("#terminalState").html("----");
			  $("#terminalState").attr("class","");
			  $("#terminal_lv").html("----");
			  $("#terminal_success").html("----");
			  $("#terminal_falid").html("----");
			  $("#terminal_xq").html("");
		}else{
			if(type.indexOf("%")!=-1){
				$("#terminalState").html("成功");
				loadTerminalCount();
				$("#terminal_xq").html("...");
			}else{
				$("#terminalState").html("失败");
				$("#terminalState").attr("class","cred");
				$("#terminal_lv").html("0%");
				$("#terminal_success").html("0");
				$("#terminal_falid").html("0");
				$("#terminal_xq").html("");
			}
		}
	}
	
	loadCmcc = function(type){
		if(type==null || type== "" ||type == "null"){
			  $("#cmccState").html("----");
			  $("#cmccState").attr("class","");
			  $("#cmcc_lv").html("----");
			  $("#cmcc_success").html("----");
			  $("#cmcc_falid").html("----");
			  $("#cmcc_xq").html("");
		}else{
			if(type.indexOf("成功")!=-1){
				$("#cmccState").html("成功");
				loadCmccCount();
				$("#cmcc_xq").html("...");
			}else{
				$("#cmccState").html("失败");
				$("#cmccState").attr("class","cred");
				$("#cmcc_lv").html("0%");
				$("#cmcc_success").html("0");
				$("#cmcc_falid").html("0");
				$("#cmcc_xq").html("");
			}
		}
	}
	
	
	loadLed = function(type){
		if(type==null || type== "" ||type == "null"){
			  $("#ledState").html("----");
			  $("#ledState").attr("class","");
			  $("#led_lv").html("----");
			  $("#led_success").html("----");
			  $("#led_falid").html("----");
			  $("#led_xq").html("");
		}else{
			if(type.indexOf("成功")!=-1){
				$("#ledState").html("成功");
				$("#led_lv").html("100%");
				$("#led_success").html("4");
				$("#led_falid").html("0");
				 $("#led_xq").html("...");
			}else{
				$("#ledState").html("失败");
				$("#ledState").attr("class","cred");
				$("#led_lv").html("0%");
				$("#led_success").html("0");
				$("#led_falid").html("0");
				 $("#led_xq").html("");
			}
		}
	}
	
	
	loadWeibo = function(type,id){
		if(type==null || type== "" ||type == "null"){
			  $("#"+id+"State").html("----");
			  $("#"+id+"State").attr("class","");
			  $("#"+id+"_lv").html("----");
			  $("#"+id+"_success").html("----");
		}else{
			if(type.indexOf("成功")!=-1){
				$("#"+id+"State").html("成功");
				$("#"+id+"_lv").html("100%");
				$("#"+id+"_success").html("1");
			}else{
				$("#"+id+"State").html("失败");
				$("#"+id+"State").attr("class","cred");
				$("#"+id+"_lv").html("0%");
				$("#"+id+"_success").html("0");
			}
		}
	}
	
	loadTerminalCount = function(){
		$.post("../control.terminalCount.d",{"ID":_id},function(rv){
			if(rv!=null && rv!= "" && rv != undefined){
				var lbs = eval(rv);
				var success = 0;
				for(var i =0;i<lbs.length;i++){
					if(lbs[i].result == 'success'){
						success ++;
					}
				}
				$("#terminal_success").html(success);
				$("#terminal_falid").html((lbs.length-success));
				if(lbs.length!=0){
					if(success==0){
						$("#terminal_lv").html("0%");
					}else{
						$("#terminal_lv").html(Math.round((success*100)/lbs.length)+"%");
					}
				}
			}
		});
	}
	
	loadCmccCount = function(){
		$.post("../control.cmccCount.d",{"ID":_id},function(rv){
			if(rv!=null && rv!= "" && rv != undefined){
				var lbs = eval(rv);
				var success = 0;
				for(var i =0;i<lbs.length;i++){
					if(lbs[i].result == 'true'){
						success ++;
					}
				}
				$("#cmcc_success").html(success);
				$("#cmcc_falid").html((lbs.length-success));
				if(lbs.length!=0){
					if(success==0){
						$("#cmcc_lv").html("0%");
					}else{
						$("#cmcc_lv").html(Math.round((success*100)/lbs.length)+"%");
					}
				}
			}
		});
	}
	
	openTerminalList  = function(){
		window.showModalDialog ('terminal_list.jsp?id='+_id,'newwindow','height=570,width=690,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
	}
	
	openCmccList  = function(){
		window.showModalDialog ('cmcc_list.jsp?id='+_id,'newwindow','height=570,width=690,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
	}
	
	openLedList  = function(){
		window.showModalDialog ('led_list.jsp?id='+_id,'newwindow','height=570,width=690,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
	}
	
	