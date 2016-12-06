

/** @Bind #jjtzid.onFocus  */
!function(dialogTc){
	dialogTc.show();
};



/** @Bind #btnPrintPreview.onClick  */
!function(dsInformSingle){
	var id=dsInformSingle.getData().get("id");
	/*window.open("reportJsp/xyml_fb.jsp?sqlwhere_num=f.id='"+id+"'");*/
	window.open("pageoffice/word_xyml_fb.jsp?id="+id);
};



/** @Bind #btnbackfill.onClick  */
!function(dgSelected,dialogTc,dsInformSingle){
	var dataset =dgSelected.get("dataSet");
	var row = dataset.getData("#");
	var jjtzId= row.get("jjtzId");
	var subject= row.get("subject");
	
	dsInformSingle.getData().set('jjtzId',jjtzId);
	dsInformSingle.getData().set('relatedNotice',subject);
	
	dialogTc.hide();
};











/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};


//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsInformSingle,tcShow,ctinfo,iframeEmbed){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		iframeEmbed.set('path',"pageoffice/word_xyml_fb.jsp?id="+_id);
		iframeEmbed.reload();
	}
	tcShow.set('currentTab',ctinfo);
};


//@Bind #btnCreate.onClick
!function(doSomeThingAction,dsInformSingle){
	var status=dsInformSingle.getData().get("status");
	if (status) {
		if (status=='待审核') {
			var username='${session.getAttribute("username")}';
			dsInformSingle.getData().set('appby',username);
			doSomeThingAction.execute();
		}else if (status=='已批准') {
			alert('指令已经批准');
		}else if (status=='已发布') {
			alert('指令已经发布');
		} 
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
			subject:subject,
			zhlx:zhlx,
			content:content
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};