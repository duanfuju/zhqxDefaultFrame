//设置全局变量
var pkey;


/** @Bind #dgMain.onDataRowDoubleClick */
!function(dgMain,tcMain,ctSecond,dsBranch){
	var dataset =dgMain.get("dataSet");
	var row = dataset.getData("#");
	var id= row.get("id");
	if (id) {
		dsBranch.set("parameter",id);
		dsBranch.flushAsync();
		pkey=id;
		tcMain.set('currentTab',ctSecond);
	}else{
		alert("选择失败,请先点击保存");
	}
};



/** @Bind #tbbInsert.onClick */
!function(dsBranch){
	if (!pkey) {
		return;
	}
	dsBranch.insert({
		associationNumber:pkey
	});
};


/** @Bind #tbbEditM.onClick */
!function(dgMain){
	dgMain.set('readOnly',false);
};

/** @Bind #tbbSaveM.onClick */
!function(saveMainAction,dgMain){
	saveMainAction.execute();
	dgMain.set('readOnly',true);
};
/** @Bind #tbbInsertM.onClick */
!function(dsMain,dgMain){
	dsMain.insert();
	dgMain.set('readOnly',false);
};