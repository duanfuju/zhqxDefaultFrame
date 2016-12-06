/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};





/** @Bind #lddZhlx.onValueSelect  */
!function(lddZhlx,dsbzid,arg,txtbzid,dsInformSingle){
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
			if (status=='拟稿') {
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
!function(txtzt,txtzhlx,txtjjtznr,dsInformList){
	var zt= txtzt.get("text");
	var zhlx= txtzhlx.get("text");
	var jjtz= txtjjtznr.get("text");
	if (!zt) {
		zt='%';
	}
	if (!jjtz) {
		jjtz='%';
	}
	if (!zhlx) {
		zhlx='%';
	}
	var parameter={
			zt:zt,
			zhlx:zhlx,
			jjtz:jjtz
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};