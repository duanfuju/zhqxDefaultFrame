/*************************ctBaseInfo start*****************************/
/** @Bind #updateAction1.onSuccess  */
!function(dsAllBaseInfo,dgAllBaseInfo){
	dsAllBaseInfo.flushAsync();
	dgAllBaseInfo.set('readOnly',true);
};
/** @Bind #tbAdd3.onClick  */
!function(dsAllBaseInfo,dgAllBaseInfo){
	dsAllBaseInfo.insert();
	dgAllBaseInfo.set('readOnly',false);
};
/** @Bind #tbUpdate3.onClick  */
!function(updateAction3,dgAllBaseInfo){
	updateAction3.execute();
	dgAllBaseInfo.set('readOnly',true);
};
/** @Bind #tbPreUpdate3.onClick  */
!function(dgAllBaseInfo){
	dgAllBaseInfo.set('readOnly',false);
};
/** @Bind #dgAllBaseInfo.onDataRowDoubleClick */
!function(dgAllBaseInfo,tcShow,ctProblem,dsProblem){
	var dataset =dgAllBaseInfo.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("ylId");
	if (_id) {
		dsProblem.set("parameter",{'ylId':_id});
		dsProblem.flushAsync();
	}
	tcShow.set('currentTab',ctProblem);
};
/*************************ctBaseInfo end*****************************/

/*************************ctProblem start*****************************/

/** @Bind #updateAction1.onSuccess  */
!function(dsProblem,dgProblem){
	dsProblem.flushAsync();
	dgProblem.set('readOnly',true);
};
/** @Bind #tbAdd1.onClick  */
!function(dsProblem,dgProblem){
	var dataset = dgProblem.get("dataSet");
	var row = dataset.getData("#");
	var ylId= row.get("ylId");
	dsProblem.insert({'ylId':ylId});
	dgProblem.set('readOnly',false);
};
/** @Bind #tbUpdate1.onClick  */
!function(updateAction1,dgProblem){
	updateAction1.execute();
	dgProblem.set('readOnly',true);
};
/** @Bind #tbPreUpdate1.onClick  */
!function(dgProblem){
	dgProblem.set('readOnly',false);
};
/** @Bind #dgProblem.onDataRowDoubleClick */
!function(dgProblem,tcShow,ctResultRecord,dsResultRecord){
	var dataset =dgProblem.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsResultRecord.set("parameter",{'answerId':_id});
		dsResultRecord.flushAsync();
	}
	tcShow.set('currentTab',ctResultRecord);
};
/*************************ctProblem end*****************************/

/*************************ctResultRecord end*****************************/
/** @Bind #tbAdd2.onClick  */
!function(dsResultRecord,dgResultRecord){
	var dataset = dgResultRecord.get("dataSet");
	var row = dataset.getData("#");
	var answerId= row.get("answerId");
	dsResultRecord.insert({'answerId':answerId});
};
/** @Bind #tbUpdate2.onClick  */
!function(updateAction2){
	updateAction2.execute();
};
/*************************ctResultRecord end*****************************/
