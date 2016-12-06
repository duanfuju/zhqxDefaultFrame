//由于上传的方法在一个窗口中只能调用一次，所以用一个全局变量来判断
var isType="0";

/** @Bind #dsNp0.onReady  */
!function(dsNp0,dsNp1,dsNp2){
	//为第一个页签的填充数据
	var param0={type:"0"};
	dsNp0.set("parameter",param0);
	dsNp0.flushAsync();
	
	//为第三个页签的填充数据
	var param1={type:"1"};
	dsNp1.set("parameter",param1);
	dsNp1.flushAsync();
	
	//为第四个页签的填充数据
	var param2={type:"2"};
	dsNp2.set("parameter",param2);
	dsNp2.flushAsync();
};




/*************************the first tab start**********************************/
/** @Bind #tbbAdd0.onClick  */
!function(dsNp0){
	dsNp0.insert({nkType:"0"});
};
/*************************the first tab end**********************************/
/*************************the second tab start**********************************/
/** @Bind #tbbAdd1.onClick  */
!function(dsNp1){
	dsNp1.insert({nkType:"1"});
};
/*************************the second tab end**********************************/
/*************************the fouth tab start**********************************/
/** @Bind #tbbAdd2.onClick  */
!function(dsNp2){
	dsNp2.insert({nkType:"2"});
};
/*************************the fouth tab end**********************************/



















/**------上传 start---------*/
/** @Bind #btnFile0.onClick   */
!function(fileDialog,fileIFrame,dgNp0){//这个是第一个页签的点击
	isType="0";
	doUp(fileDialog,fileIFrame,dgNp0);
};

/** @Bind #btnFile1.onClick   */
!function(fileDialog,fileIFrame,dgNp1){//这个是第三个页签的点击
	isType="1";
	doUp(fileDialog,fileIFrame,dgNp1);
};

/** @Bind #btnFile2.onClick   */
!function(fileDialog,fileIFrame,dgNp2){//这个是第四个页签的点击
	isType="2";
	doUp(fileDialog,fileIFrame,dgNp2);
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
		var datagrid="" ;//获取datagrid用于之后回填
		var action="";//获取action用于之后保存
		if (isType=="0") {
			datagrid =  view.get("#dgNp0");
			action = view.get("#Np0Action");
		}else if (isType=="1") {
			datagrid =  view.get("#dgNp1");
			 action = view.get("#Np1Action");
		}else if (isType=="2") {
			datagrid = view.get("#dgNp2");
			 action = view.get("#Np2Action");
		}
		var dataset =datagrid.get("dataSet");
		var data = dataset.getData("#");
		data.set("fileid",fileid);
		data.set("nkName",filename);
		view.get("#fileDialog").hide();
		action.execute();
	}
};

/**------上传 end---------*/

