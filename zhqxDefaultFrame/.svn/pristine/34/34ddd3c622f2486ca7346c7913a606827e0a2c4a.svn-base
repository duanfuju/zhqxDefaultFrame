/** @Bind #btnCreate.onClick  */
!function(saveAction,dsInformSingle,doSomeThingAction,dsContact){
	
	var username='${session.getAttribute("username")}';
	dsInformSingle.getData().set('pubby',username);
	saveAction.execute();
	doSomeThingAction.execute();
};




/** @Bind #btnPrintPreview.onClick  */
!function(dsInformSingle){
	var id=dsInformSingle.getData().get("id");
	/*window.open("reportJsp/jjtz_fb_fw.jsp?sqlwhere_num=f.id='"+id+"'");*/
	window.open("pageoffice/word_jjtz_fb.jsp?id="+id);
};






/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};

/** @Bind #tbbAdd.onClick  */
!function(dsInformSingle,dsContact){
	var jjtzId=dsInformSingle.getData().get("jjtzId");
	dsContact.insert({
		"jjtzId":jjtzId,
	});
};
//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsInformSingle,tcShow,ctinfo,dsContact,iframeEmbed){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	var jjtzId=row.get("jjtzId");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		dsContact.set("parameter",jjtzId);
		dsContact.flushAsync();
		iframeEmbed.set('path',"pageoffice/word_jjtz_fb.jsp?id="+_id);
		iframeEmbed.reload();
	}
	tcShow.set('currentTab',ctinfo);
	
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