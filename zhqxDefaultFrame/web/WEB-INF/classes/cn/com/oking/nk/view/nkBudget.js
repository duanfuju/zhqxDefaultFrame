//由于上传的方法在一个窗口中只能调用一次，所以用一个全局变量来判断
var isType="0";



/*********************政策文件页签 start****************************/




//@Bind #dsZcwj.onReady 
!function(dsZcwj){
	dsZcwj.set('parameter',{type:"yskz"});
	dsZcwj.flushAsync();
};

//@Bind #tbbZcwj.onClick 
!function(dsZcwj){
	dsZcwj.insert({
		'zcwjType':'yskz'
	});
};

//@Bind #btnFileWithZcwj.onClick 
!function(fileDialog,fileIFrame,dgZcwj){
	isType="-1";
	doUp(fileDialog,fileIFrame,dgZcwj);
};





/**********************政策文件页签 end***************************/













//需要传入Echarts的三个数组
var contentArray=[];		
var expendBudgetArray=[];	
var realExpendArray=[];		
var idArray=[];


/*************************the first tab start**********************************/
//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsNkBudgetExpend,dsBudgetSingle,tcShow,ctSecond,dsRecord2,dsRecord1){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("nkId");
	if (_id) {
		//第二个页签中表单中的值
		dsBudgetSingle.set("parameter",_id);
		dsBudgetSingle.flushAsync();
		
		//第二个页签中Echarts的值
		dsNkBudgetExpend.set("parameter",_id);
		
		//初始化数组
		 contentArray=[];
		 expendBudgetArray=[];
		 realExpendArray=[];
		 idArray=[];
		//获取需要传入Echarts的对象集合
		dsNkBudgetExpend.getData().each(function(e){
			contentArray.push(e.get("content"));
			expendBudgetArray.push(e.get("expendBudget"));
			realExpendArray.push(e.get("realExpend"));
			idArray.push(e.get("id"));
		});
		var param1={
				id:_id,
				type:"0"
		};
		var param2={
				id:_id,
				type:"1"
		};
		
		dsRecord1.set("parameter",param1);
		dsRecord1.flushAsync();
		dsRecord2.set("parameter",param2);
		dsRecord2.flushAsync();
	}
	tcShow.set('currentTab',ctSecond);
};


//@Bind #dgShow.#revenueBudget.onRenderCell
!function(arg) {
	var entity = arg.data;
	arg.dom.innerText =entity.get("revenueBudget")/10000;
};
//@Bind #dgShow.#expendBudget.onRenderCell
!function(arg) {
	var entity = arg.data;
	arg.dom.innerText =entity.get("expendBudget")/10000;
};
//@Bind #dgShow.#realRevenue.onRenderCell
!function(arg) {
	var entity = arg.data;
	arg.dom.innerText =entity.get("realRevenue")/10000;
};
//@Bind #dgShow.#realExpend.onRenderCell
!function(arg) {
	var entity = arg.data;
	arg.dom.innerText =entity.get("realExpend")/10000;
};


/** @Bind #btnAdd.onClick  */
!function(dsBudgetSingle,tcShow,ctSecond,dsRecord1,dsRecord2){
	dsRecord2.clear();
	dsRecord1.clear();
	dsBudgetSingle.clear();
	dsBudgetSingle.insert();
	tcShow.set('currentTab',ctSecond);
	
};

/*************************the first tab end**********************************/









/*************************the second tab start*******************************/
/** @Bind #btnSave.onClick  */
!function(saveBudgetSingleAction,dsBudgetList){
	saveBudgetSingleAction.execute();
	dsBudgetList.flushAsync();
};



 

/** @Bind #tcShow.onTabChange   */
!function(){
	createIcon(contentArray,expendBudgetArray,realExpendArray); 
};

/** @Bind #hcShow.onReady  */
!function(){
	createIcon(contentArray,expendBudgetArray,realExpendArray); 
};

/*************************the second tab end**********************************/










/*************************the second tab 1start********************************/
/** @Bind #tbbAdd1.onClick  */
!function(dsRecord1,dsBudgetSingle){
	var _id=dsBudgetSingle.getData().get("nkId");
	dsRecord1.insert({
		nkType:"0",
		nkNum:_id
	});
};

/*************************the second tab 1end**********************************/











/*************************the second tab 2start********************************/
/** @Bind #tbbAdd2.onClick  */
!function(dsRecord2,dsBudgetSingle){
	var _id=dsBudgetSingle.getData().get("nkId");
	dsRecord2.insert({
		nkType:"1",
		nkNum:_id
	});
};






function createIcon(contentArray,expendBudgetArray,realExpendArray){
	 // 基于准备好的dom，初始化echarts图表
	var dom=document.getElementById('icon');
	if (!dom) {
		return;
	}
	var myChart = echarts.init(dom);
	option = {
		    title : {
		        text: '支出情况',
		        x: "center"
		    },
		    tooltip : {
		        trigger: 'axis',
		        formatter:function(a){
		        	//"{b}<br/>{a}:{c}<br/>{a1}:{c1}<br/>完成进度:{c}:{c1}"
		        	var relVal="";
		        	relVal=a[0][0]+":"+a[0][2]+"<br/>";
		        	relVal+=a[1][0]+":"+a[1][2]+"<br/>";
		        	relVal+="完成进度:"+ (a[0][2]/a[1][2]).toFixed(4)*100+"%";
		        	return relVal;
		        }
		    },
		    legend: {
		    	 x: 'left',
		        data:[ '实际支出','支出预算']
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
		    xAxis : [
		        {
		            type : 'value',
		            boundaryGap : [0, 0.01]
		        }
		    ],
		    yAxis : [
		        {
		            type : 'category',
		            data : contentArray
		        }
		    ],
		    series : [
				{
					special:realExpendArray,
				    name:'实际支出',
				    type:'bar',
				    itemStyle: {
		                normal: {                   // 系列级个性化，横向渐变填充
		                	barBorderRadius: [0,5,5,0],//指定柱形4个圆角半径，如:[5, 5, 0, 0]（顺时针左上，右上，右下，左下）
		                    label : {
		                        show : true,
		                        textStyle : {
		                            fontSize : '12',
		                            fontFamily : '微软雅黑'
		                        }
		                    }
		                }
		            },
				    data:realExpendArray
				},
		        {
		            name:'支出预算',
		            type:'bar',
		            itemStyle: {
		                normal: {                   // 系列级个性化，横向渐变填充
		                	barBorderRadius: [0,5,5,0],//指定柱形4个圆角半径，如:[5, 5, 0, 0]（顺时针左上，右上，右下，左下）
		                    label : {
		                        show : true,
		                        textStyle : {
		                            fontSize : '12',
		                            fontFamily : '微软雅黑'
		                        }
		                    }
		                }
		            },
		            data:expendBudgetArray
		        }
		        
		    ]
		};
	myChart.setOption(option);
	function clickEvent(param) {
		var res=checkName(param.name);
		if (res!=-1) {
			 var dsParentId=view.get("#dsParentId");
			 dsParentId.set("parameter",idArray[res]);
			 dsParentId.flush();
			 contentArray=[];
			 expendBudgetArray=[];
			 realExpendArray=[];
			 idArray=[];
			//获取需要传入Echarts的对象集合
			 dsParentId.getData().each(function(e){
				contentArray.push(e.get("content"));
				expendBudgetArray.push(e.get("expendBudget"));
				realExpendArray.push(e.get("realExpend"));
				idArray.push(e.get("id"));
			});
			 createIcon(contentArray,expendBudgetArray,realExpendArray); 
		}
	}
	myChart.on('click',clickEvent);
}


function checkName(name){//通过name查询之前传入Echart数组的指定元素的下标   
	for ( var i = 0; i < contentArray.length; i++) {
		if (contentArray[i]==name) {
			return i;
		}
	}
	return -1;
}

/*************************the second tab 2end**********************************/











/**------上传 start---------*/
/** @Bind #btnFile.onClick   */
!function(fileDialog,fileIFrame,dgRecord1){//这个是第一个页签的点击
	isType="0";
	doUp(fileDialog,fileIFrame,dgRecord1);
};


/** @Bind #btnFile1.onClick   */
!function(fileDialog,fileIFrame,dgRecord1){//这个是第二个页签的点击
	isType="1";
	doUp(fileDialog,fileIFrame,dgRecord1);
};



function doUp(fileDialog,fileIFrame,datagrid){
	var dataset =datagrid.get("dataSet");
	var data = dataset.getData("#");
	var fileid = "";
	if(data != null){
		try{
			fileid = data.get("id");
		}catch(e){
			alert("请先保存新添加的数据，然后再次进行上传...");
			return;
		}
	}
	var _type = "fileShowPath";   //参照config.xml
	var _pathType = "xls";   //参照FileUtils文件
	var _exec = "*";     //限制上传格式
	var _size= "10MB";    //限制上传文件大小
	fileIFrame.set("path","cn.com.oking.upload.upload.d?fileid="+fileid+
			"&type="+ _type+   //showPath类型
			"&pathType="+_pathType+        //保存文件夹
			"&exec="+_exec+        //上传文件格式
			"&size="+_size);       //文件大小
	fileDialog.show();
	fileIFrame.reload();
}



window.setUploadParam = function(fileid,filename){
	if(fileid != null && fileid != "" && fileid != undefined && 
			filename != null && filename != "" && filename != undefined){
		dorado.MessageBox.alert("文件上传成功！  \n \t文件名:"+filename+"\n\t关联ID:"+fileid);
		var datagrid=null;
		var action=null;
		if (isType=="0") {
			datagrid = view.get("#dgRecord1");
			action=view.get("#saveRecord1Action");
		}else if (isType=="1") {
			datagrid = view.get("#dgRecord2");
			action=view.get("#saveRecord2Action");
		}else if (isType=="-1") {
			datagrid = view.get("#dgZcwj");
			action=view.get("#updateAction1");
		}
		var dataset =datagrid.get("dataSet");
		var data = dataset.getData("#");
		data.set("fileid",fileid);
		if (isType=="-1") {
			data.set("content",filename);
		}else{
			data.set("nkName",filename);
		}
		view.get("#fileDialog").hide();
		action.execute();
	}
};

/**------上传 end---------*/
