//由于上传的方法在一个窗口中只能调用一次，所以用一个全局变量来判断
var isType="0";



/*********************政策文件页签 start****************************/




//@Bind #dsZcwj.onReady 
!function(dsZcwj){
	dsZcwj.set('parameter',{type:"xmkz"});
	dsZcwj.flushAsync();
};

//@Bind #tbbZcwj.onClick 
!function(dsZcwj){
	dsZcwj.insert({
		'zcwjType':'xmkz'
	});
};

//@Bind #btnFileWithZcwj.onClick 
!function(fileDialog,fileIFrame,dgZcwj){
	isType="-1";
	doUp(fileDialog,fileIFrame,dgZcwj);
};





/**********************政策文件页签 end***************************/






/***********************ctFirst start**************/

var _id="";

/** @Bind #btnAdd.onClick   */
!function(dsRecord,dgRecord){
	dgRecord.set("readOnly",false);
	dsRecord.insert();
};

/** @Bind #tbbSave.onClick   */
!function(updateAction2,dgRecord){
	dgRecord.set("readOnly",true);
	updateAction2.execute();
};



//@Bind #dgRecord.onDataRowDoubleClick 
!function(dgRecord,tcShow,ctSecond,dsGckz){
	var dataset =dgRecord.get("dataSet");
	var row = dataset.getData("#");
	_id= row.get("nkId");
	var param={
			id:_id
	};
	dsGckz.set("parameter",param);
	dsGckz.flushAsync();
	tcShow.set('currentTab',ctSecond);
};


/***********************ctFirst end**************/




/** @Bind #tbbAdd1.onClick   */
!function(dsGckz){
	dsGckz.insert({
		"nkNum":_id
	});
};


/** @Bind #tbbSave1.onClick   */
!function(updateAction0){
	updateAction0.execute();
};



/** @Bind #btnFile.onClick   */
!function(fileDialog,fileIFrame,dgGckz){//这个是第二个页签的点击
	isType="1";
	doUp(fileDialog,fileIFrame,dgGckz);
};



/**------上传 start---------*/

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
		 if (isType=="1") {
			datagrid = view.get("#dgGckz");
			action=view.get("#updateAction0");
		}else if (isType=="-1") {
			datagrid = view.get("#dgZcwj");
			action=view.get("#updateAction1");
		}
		
		
		
		var dataset =datagrid.get("dataSet");
		var data = dataset.getData("#");
		data.set("fileid",fileid);
		data.set("content",filename);
		view.get("#fileDialog").hide();
		action.execute();
	}
};

/**------上传 end---------*/