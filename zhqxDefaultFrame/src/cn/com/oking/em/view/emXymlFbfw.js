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
	/*window.open("reportJsp/xyml_fb_fw.jsp?sqlwhere_num=f.id='"+id+"'");*/
	window.open("pageoffice/word_xyml_fb.jsp?id="+id);
};






/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};

/** @Bind #tbbAdd.onClick  */
!function(dsInformSingle,dsContact){
	var zlbhId=dsInformSingle.getData().get("zlbhId");
	dsContact.insert({
		"zlbhId":zlbhId
	});
};
//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsInformSingle,tcShow,ctinfo,dsContact,iframeEmbed){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	var zlbhId=row.get("zlbhId");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		dsContact.set("parameter",zlbhId);
		dsContact.flushAsync();
		iframeEmbed.set('path',"pageoffice/word_xyml_fb.jsp?id="+_id);
		iframeEmbed.reload();
	}
	tcShow.set('currentTab',ctinfo);
	
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