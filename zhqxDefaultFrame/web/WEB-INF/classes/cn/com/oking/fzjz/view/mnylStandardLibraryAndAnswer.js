
/*************************ctStandardLibrary start*****************************/
var _id;
/** @Bind #updateAction1.onSuccess  */
!function(dsStandardLibrary,dgStandardLibrary){
	dsStandardLibrary.flushAsync();
	dgStandardLibrary.set('readOnly',true);
};
/** @Bind #tbAdd1.onClick  */
!function(dsStandardLibrary,dgStandardLibrary){
	dsStandardLibrary.insert();
	dgStandardLibrary.set('readOnly',false);
};
/** @Bind #tbPreUpdate1.onClick  */
!function(dgStandardLibrary){
	dgStandardLibrary.set('readOnly',false);
};
/** @Bind #tbUpdate1.onClick  */
!function(updateAction1,dgStandardLibrary){
	updateAction1.execute();
	dgStandardLibrary.set('readOnly',true);
};
/** @Bind #dgStandardLibrary.onDataRowDoubleClick */
!function(dgStandardLibrary,tcShow,ctAnswer,dsAnswer){
	var dataset = dgStandardLibrary.get("dataSet");
	var row = dataset.getData("#");
	_id= row.get("id");
	if (_id) {
		dsAnswer.set("parameter",{'answerId':_id});
		dsAnswer.flushAsync();
	}
	tcShow.set('currentTab',ctAnswer);
};
/*************************ctStandardLibrary end*****************************/

/*************************ctAnswer start*****************************/
/** @Bind #tbAdd2.onClick  */
!function(dgAnswer,dsAnswer){
	/*var dataset = dgAnswer.get("dataSet");
	var row = dataset.getData("#");
	var answerId= row.get("answerId");*/
	dsAnswer.insert({'answerId':_id});
};
/** @Bind #tbUpdate2.onClick  */
!function(updateAction2){
	updateAction2.execute();
};
/*************************ctAnswer end*****************************/