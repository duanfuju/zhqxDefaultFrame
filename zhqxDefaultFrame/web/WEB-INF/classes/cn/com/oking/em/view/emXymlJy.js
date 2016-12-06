

/** @Bind #jjtzid.onFocus  */
!function(dialogTc){
	dialogTc.show();
};




/** @Bind #btnbackfill.onClick  */
!function(dgSelected,dialogTc,dsInformSingle){
	var dataset =dgSelected.get("dataSet");
	var row = dataset.getData("#");
	var jjtzId= row.get("jjtzId");
	var subject= row.get("subject");
	
	dsInformSingle.getData().set('jjtzId',jjtzId);
	dsInformSingle.getData().set('subject',subject);
	dialogTc.hide();
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
!function(dgShow,dsInformSingle,tcShow,ctinfo){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
	}
	tcShow.set('currentTab',ctinfo);
};

//@Bind #btnClear.onClick
!function(dsInformSingle){
	dsInformSingle.clear();
	dsInformSingle.insert();
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
!function(txtzhlx,txtjjtznr,dsInformList){
	var zhlx= txtzhlx.get("text");
	var content= txtjjtznr.get("text");
	
	if (!content) {
		content='%';
	}
	if (!zhlx) {
		zhlx='%';
	}
	var parameter={
			zhlx:zhlx,
			content:content
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};