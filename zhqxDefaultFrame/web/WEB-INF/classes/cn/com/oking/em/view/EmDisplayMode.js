/*************************ctFirst start*****************************/

/** @Bind #saveListAction.onSuccess  */
!function(dsDisplayMode,dgDisplayMode){
	dsDisplayMode.flushAsync();
	dgDisplayMode.set('readOnly',true);
};
/** @Bind #tbbAdd.onClick  */
!function(dsDisplayMode,dgDisplayMode){
	dsDisplayMode.insert({'type':'¶¨ÖÆ'});
	dgDisplayMode.set('readOnly',false);
};
/** @Bind #tbbUpdate.onClick  */
!function(saveListAction,dgDisplayMode){
	saveListAction.execute();
	dgDisplayMode.set('readOnly',true);
};
/** @Bind #tbbPreUpdate.onClick  */
!function(dgDisplayMode){
	dgDisplayMode.set('readOnly',false);
};

/** @Bind #dgDisplayMode.onDataRowDoubleClick */
!function(dgDisplayMode,dsDisplayModeSingle,tcShow,ctSecond,dsModeContent){
	var dataset =dgDisplayMode.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("dmId");
	if (_id) {
		dsDisplayModeSingle.set("parameter",_id);
		dsDisplayModeSingle.flushAsync();
		dsModeContent.set("parameter",{'dmId':_id});
		dsModeContent.flushAsync();
	}
	tcShow.set('currentTab',ctSecond);
};
/*************************ctFirst end*****************************/


/*************************ctSecond start***************************/
/** @Bind #tbbAddc.onClick  */
!function(dialogShow){
	dialogShow.show();
};
/** @Bind #btnSave.onClick  */
!function(dsDisplayModeSingle,dsModeContent,dgContentList){
	var ds=dsDisplayModeSingle.getData();
	var dmId=ds.get("dmId");
	
	var dataset =dgContentList.get("dataSet");
	var row = dataset.getData("#");
	var clNum= row.get("clNum");
	var description= row.get("description");
	var url= row.get("url");
	var displaySize= row.get("displaySize");
	var imgSrc= row.get("imgSrc");
	dsModeContent.insert({'dmId':dmId,'clNum':clNum,'description':description
		,'url':url,'displaysize':displaySize,'imgSrc':imgSrc});
};
/** @Bind #btnCancel.onClick  */
!function(dialogShow){
	dialogShow.hide();
};
/*************************ctSecond end****************************/