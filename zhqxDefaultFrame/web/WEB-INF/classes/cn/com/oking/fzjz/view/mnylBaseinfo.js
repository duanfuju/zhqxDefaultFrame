var zhCase="";//典型案例
var zhId="";//案例库编号
//演练模式
//角色选择
//部门







/** @Bind #tbbAddSingle.onClick  */
!function(dsBaseInfo){
	dsBaseInfo.clear();
	dsBaseInfo.insert({
		ylStatus:"准备就绪"
	});
};

/** @Bind #tbbLook.onClick  */
!function(dialogLook){
	dialogLook.show();
};




/** @Bind #dgAllBaseInfo.onDataRowDoubleClick */
!function(dgAllBaseInfo,tcShow,ctFirst,iframeRecord,dsBaseInfo){
	
	
	var datagrid = this.get("#dgAllBaseInfo");
	var dataset =datagrid.get("dataSet");
	var row = dataset.getData("#");
	var ylId= row.get("ylId");
	tcShow.set('currentTab',ctFirst);
	dsBaseInfo.set("parameter",ylId);
	dsBaseInfo.flushAsync();
	iframeRecord.set("path","pageoffice/excel_mnyl.jsp?ylId="+ylId);
};









/** @Bind #dsBaseInfo.onReady  */
!function(dsBaseInfo){
	dsBaseInfo.insert({
		ylStatus:"准备就绪"
	});
};


/** @Bind #ifShow.onReady  */
!function(ifShow){
	ifShow.set("path","fzjz/commonLink.jsp?roleId=气象局");
};



/** @Bind #dsddRole.onValueSelect  */
!function(ifShow,arg,txtdept){
	var role = arg.selectedValue;
	if (role=="部门联络人") {
		txtdept.set("readOnly",false);
	}else{
		txtdept.set("readOnly",true);
	}
	ifShow.set("path","fzjz/commonLink.jsp?roleId="+role);
};


/** @Bind #btnStart.onClick  */
!function(saveBaseInfoAction,txtylStatus){
	var val=txtylStatus.get("text");
	if (val=="准备就绪") {
		saveBaseInfoAction.execute();
	}else{
		alert("演练进行中或结束!!!");
	}
};

/** @Bind #saveBaseInfoAction.onSuccess */
!function(txtylStatus,dsAllBaseInfo,txtdrillMode,txtroleSelection,txtdept,dsBaseInfo,gbYl,iframeProblem,iframeRecord){
	var s = txtylStatus.get("text");
	//典型案例、案例库编号、演练模式、角色选择、部门 、zhCase;zhId;
	var drillMode=txtdrillMode.get("text");
	var roleSelection=txtroleSelection.get("text");
	var dept=txtdept.get("text");
	var data=dsBaseInfo.getData();
	var ylId=data.get("ylId");
	if (s=="准备就绪") {
		 //因为tomcat中为项目配置过中文路径，所以在本地运行时使用c_problems.jsp,上传到服务中运行时使用problems.jsp
		 iframeProblem.set("path","fzjz/c_problems.jsp?zhCase="+zhCase
				 					+"&zhId="+zhId
				 					+"&drillMode="+drillMode
				 					+"&roleSelection="+roleSelection
				 					+"&dept="+dept
				 					+"&ylId="+ylId, "_blank");
		 //闭合
		 //gbYl.set("collapsed",true);
	}else{
//		iframeRecord.set("path","fzjz/record.jsp?ylId="+ylId);
		iframeRecord.set("path","pageoffice/excel_mnyl.jsp?ylId="+ylId);
	}
	dsAllBaseInfo.flushAsync();
};







/** @Bind #btnEnd.onClick  */
!function(saveBaseInfoAction,txtylStatus){
	var s=txtylStatus.get("text");
	if (s=="演练进行中") {
		txtylStatus.set("text","演练结束");
		saveBaseInfoAction.execute();
	}else{
		alert("演练未在进行中");
	}
};



/** @Bind #txtSelection.onClick  */
!function(dialogSelection){
	dialogSelection.show();
};




/** @Bind #btnConfirm.onClick  */
!function(dialogSelection,dgSelection,txtSelection,txtZhlx,txtZhStartTime,txtZhEndTime,txtZhContinuedTime){
	var ds =dgSelection.get("dataSet");
	var row = ds.getData("#");
	
	zhId = row.get("zhId");
	zhCase = row.get("zhCase");
	var zhLx= row.get("zhLx");
	var zhStartTime= row.get("zhStartTime");
	var zhEndTime= row.get("zhEndTime");
	var zhContinuedTime= row.get("zhContinuedTime");
	
	txtSelection.set("text",zhCase);
	txtZhlx.set("text",zhLx);
	txtZhStartTime.set("text",zhStartTime);
	txtZhEndTime.set("text",zhEndTime);
	txtZhContinuedTime.set("text",zhContinuedTime);
	
	dialogSelection.hide();
};


/** @Bind #btnCancel.onClick  */
!function(dialogSelection){
	dialogSelection.hide();
};