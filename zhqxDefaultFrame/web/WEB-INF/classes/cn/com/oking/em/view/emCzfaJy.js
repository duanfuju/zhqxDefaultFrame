/** @Bind #dsddbzid.onValueSelect  */
!function(arg,dsJyShow){
	var bzid = arg.selectedValue;
	var parameter={
			bzid:bzid
	};
	dsJyShow.set("parameter",parameter);
	dsJyShow.flushAsync();
};




/** @Bind #btnAdd.onClick  */
!function(updateAction,saveJyAction,dsJyShow,dsInformSingle){
	updateAction.doExecuteAsync();
	var _id=dsInformSingle.getData().get("id");
	dsJyShow.getData().each(function(entity){
		entity.set("czfaJyId",_id);
	});
	saveJyAction.execute();
};







/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};

/** @Bind #lddZhlx.onValueSelect  */
!function(lddZhlx,dsbzid,arg,dsInformSingle){
	var zhlx = arg.selectedValue;
	dsbzid.set("parameter",zhlx);
	dsbzid.flushAsync();
	dsInformSingle.getData().set("bzId",null);
};
    
//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsInformSingle,tcShow,ctinfo,dsJyShow){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		var parameter={
				'czfaJyId':_id
		};
		dsJyShow.set("parameter",parameter);
		dsJyShow.flushAsync();
	}
	tcShow.set('currentTab',ctinfo);
};

//@Bind #btnClear.onClick
!function(dsInformSingle,dsJyShow){
	dsInformSingle.clear();
	dsInformSingle.insert();
	dsJyShow.clear();
};

//@Bind #btnCreate.onClick
!function(doSomeThingAction,dsInformSingle){
	var status=dsInformSingle.getData().get("status");
	var id=dsInformSingle.getData().get("id");
	if (id) {
		if (status) {
			if (status=='待审核') {
				var username='${session.getAttribute("username")}';
				dsInformSingle.getData().set('createby',username);
				doSomeThingAction.execute();
			}else{
				alert('状态的值输入不正确，请确认！！！');
			}
		}
	}else{
		alert("请先保存数据！！！");
	}
};

/** @Bind #btnLikeSearch.onClick  */
!function(txtorderNumber,txtzhlx,dsInformList){
	var zhlx= txtzhlx.get("text");
	var orderNumber= txtorderNumber.get("text");
	if (!orderNumber) {
		orderNumber='%';
	}
	if (!zhlx) {
		zhlx='%';
	}
	var parameter={
			zhlx:zhlx,
			orderNumber:orderNumber
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};